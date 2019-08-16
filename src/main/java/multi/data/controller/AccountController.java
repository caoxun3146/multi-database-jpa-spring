package multi.data.controller;

import com.alibaba.fastjson.JSON;

import multi.data.dao.model.other.redpacks.JsonRedpackBean;
import multi.data.dao.model.primary.Account;
import multi.data.dao.model.primary.AlimamaOrder;
import multi.data.dao.model.primary.Commodity;
import multi.data.dao.model.primary.Settlement;
import multi.data.dao.repo.primary.AccountRepository;
import multi.data.dao.repo.primary.SettlementRepository;
import multi.data.service.service.AlimamaOrderService;
import multi.data.service.service.CommodityService;
import multi.data.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SettlementRepository settlementRepository;
    @Autowired
    private AlimamaOrderService alimamaOrderService;

    @Autowired
    private CommodityService commodityService;

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    /**
     * 1 根据淘宝ID查询出数据库对应的userID, 2 根据userID查询出缓存服务器中的access_token
     *
     * @param tbID 淘宝ID
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/token/{prdID}/{tbID}")
    public String findAccessToken(@PathVariable("prdID") String prdID, @PathVariable("tbID") String tbID) throws IOException {
        byte bt = 1;  // 1 表示有效账号
        Account account = accountRepository.findByPrdIdAndTbIdAndStatus(prdID, tbID, bt);
        if (account == null || "".equals(account)) {
            logger.info("------------------> 返回对象为空");
            return "返回对象为空" + account;
        }
        logger.info("------------------ userId:" + account.getId());
        String token = AccessToken.getAccessToken(account.getId());
        return ResultUtil.success(token).getData() + "";
    }

    /**
     * 1 根据淘宝ID查询出数据库对应的userID, 2 根据userID查询出缓存服务器中的access_token
     *
     *
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/token/{UserId}")
    public String findByUserIdToken(@PathVariable("UserId") Long UserId) throws IOException {

        String token = AccessToken.getAccessToken(UserId);
        return ResultUtil.success(token).getData() + "";
    }

    /**
     * 订单结算
     *
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/settlement/{orderId}")
    public String Settlement(@PathVariable("orderId") String orderId) throws IOException, ParseException {
        Settlement settlement = settlementRepository.findByOrderId(orderId);
        if (settlement == null || "".equals(settlement)) {
            // 新增一条淘宝购物记录
            short settleStatus = 1;// 订单成功 - 1, 订单失效 - 3 ,   setOrder_status  : 订单成功/订单失效
            SimpleDateFormat simFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            Date dtBeg = simFormat.parse("2029.12.23 22:45:56");
            settlement = new Settlement(orderId, "订单成功", settleStatus, new Date(), new Date(), new Date(), dtBeg);
            Settlement saveResp = settlementRepository.save(settlement);

            // 调订单结算任务
            String URL = "http://test.vipgift.gmilesquan.com/quSuperManager/mall/fanliOrder/settleOrder.do?createTimeSpan=1&settleTimeSpan=1&findNoClientUserOrder=0";
            String result = HttpClientUtil.SendHttpRequest("GET", URL, "");

            return ResultUtil.success(result).getData() + "";
        } else {
            logger.info("------------------ 已存在该订单记录");
            return "已存在该订单记录:";
        }
    }

    /**
     * 趣专享14000 ; 柠檬省钱14200, 下单
     *
     * @param tbID
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/purchaseold/{prdID}/{tbID}") //lmpurchase
    public String PurchaseOld(@PathVariable("tbID") String tbID, @PathVariable("prdID") String prdID) throws IOException {
        byte bt = 1; //  1: 表示有效账号
        Account account = accountRepository.findByPrdIdAndTbIdAndStatus(prdID, tbID, bt);    // 增加产品ID, 趣专享 14000,  柠檬省钱 14200
        if (account == null || "".equals(account)) {
            logger.info("------------------ 返回对象为空");
            return "返回对象为空" + account;
        }
        String token = AccessToken.getAccessToken(account.getId()); // 获取token
        String orderId = RandomNumbers.getOrder(); // 生成订单号

        String sourceId = SourceIdUtil.getSourceId(); // 随机获取 1 个商品ID
        String jsonParameters = JsonData.getJsonData(token, orderId, prdID,sourceId);  // 生成请求数据
        String URL = "http://test.vipgift.gmilesquan.com/quMall/common?funid=30101";  // 下单接口
        String result = HttpClientUtil.SendHttpRequest("POST", URL, jsonParameters); // 提交下单请求, 获得响应结果

        logger.info("----------------------------------------------------------------------------");
        logger.info("响应数据 = {}", result);
        logger.info("订单号 = {}", orderId);

        return "{订单ID: " + orderId + "} " + ResultUtil.success(result).getData();
    }


    /**
     * 趣专享14000 ; 柠檬省钱14200, 下单,   通过匹配阿里妈妈订单数据, 来计算返利金额
     *
     * @param tbID
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/purchase/{prdID}/{tbID}") //lmpurchase
    public String Purchase(@PathVariable("tbID") String tbID, @PathVariable("prdID") String prdID) throws IOException {

        String orderId = RandomNumbers.getOrder(); // 生成订单号
        String sourceId = SourceIdUtil.getSourceId(); // 随机获取 1 个商品ID
        Commodity commodity = commodityService.findCommodityInfo(sourceId); // 查询商品信息 : 返利比例 , 实际价格
        logger.info("-----------------------" + commodity.getCouponFinalPrice() +"," + commodity.getTkRate() + "sourceID: " + sourceId);
        String payment = String.valueOf(commodity.getCouponFinalPrice());

        /** 生成一条阿里妈妈订单数据, 订单id 和 商品id 与30301接口上传值保持一致 **/
        AlimamaOrder alimamaOrder = new AlimamaOrder(new Date(), new Date(), "运动耳机", 525694095950L, "华胜天齐数码专营店", "华胜天齐数码专营店",
                1, "88.00", "订单付款", "天猫", commodity.getTkRate()+" %", "100.00 %", payment, "6.00",
                "0.00", "0.00", commodity.getTkRate()+" %", "0", "0.00 %", "0", "-", "无线",
                "--", orderId,
                "影音电器", "45368612", "趣专享", "23950950016", "趣专享高佣", "953470", new Date(), new Date(), 0);
        alimamaOrderService.saveAlimamaOrder(alimamaOrder);

        /** 调30301接口上传百川回调数据至用户订单表 **/
        byte bt = 1; //  1: 表示有效账号
        Account account = accountRepository.findByPrdIdAndTbIdAndStatus(prdID, tbID, bt);    // 增加产品ID, 趣专享 14000,  柠檬省钱 14200
        if (account == null || "".equals(account)) {
            logger.info("------------------ 返回对象为空");
            return "返回对象为空" + account;
        }
        String token = AccessToken.getAccessToken(account.getId()); // 获取token

        String jsonParameters = JsonData.getJsonData(token, orderId, prdID,sourceId);  // 生成请求数据
        String URL = "http://test.vipgift.gmilesquan.com/quMall/common?funid=30101";  // 下单接口
        String result = HttpClientUtil.SendHttpRequest("POST", URL, jsonParameters); // 提交下单请求, 获得响应结果

        logger.info("----------------------------------------------------------------------------");
        logger.info("响应数据 = {}", result);
        logger.info("订单号 = {}", orderId);

        return ResultUtil.success(result).getData() + ", OrderID: " + orderId;
    }

    /**
     * 通过用户ID 来下单
     * @return
     * @throws IOException
     */
    /*@GetMapping(value = "/purchase_user/{userId}") //lmpurchase
    public String PurchaseByUserId(@PathVariable("userId") long userId) throws IOException {

        String orderId = RandomNumbers.getOrder(); // 生成订单号

        String sourceId = SourceIdUtil.getSourceId(); // 随机获取 1 个商品ID   // 585330318155  返125元
        Commodity commodity = commodityService.findCommodityInfo(sourceId); // 查询商品信息 : 返利比例 , 实际价格
        logger.info("-----------------------" + commodity.getCouponFinalPrice() +"," + commodity.getTkRate() + "sourceID: " + sourceId);
        String payment = String.valueOf(commodity.getCouponFinalPrice());

        // 生成一条阿里妈妈订单数据, 订单id 和 商品id 与30301接口上传值保持一致
        AlimamaOrder alimamaOrder = new AlimamaOrder(new Date(), new Date(), "运动耳机", 525694095950L, "华胜天齐数码专营店", "华胜天齐数码专营店",
                1, "88.00", "订单付款", "天猫", commodity.getTkRate()+" %", "100.00 %", payment, "6.00",
                "0.00", "0.00", commodity.getTkRate()+" %", "0", "0.00 %", "0", "-", "无线",
                "--", orderId,
                "影音电器", "45368612", "趣专享", "23950950016", "趣专享高佣", "953470", new Date(), new Date(), 0);
        alimamaOrderService.saveAlimamaOrder(alimamaOrder);


        // 调30301接口上传百川回调数据至用户订单表
        byte bt = 1; //  1: 表示有效账号
        Account account = accountRepository.findById(userId); //  查询用户ID
        if (account == null || "".equals(account)) {
            logger.info("------------------ 返回对象为空");
            return "返回对象为空" + account;
        }
        String token = AccessToken.getAccessToken(account.getId()); // 获取token
        String jsonParameters = JsonData.getJsonData(token, orderId, account.getPrdId(),sourceId);  // 生成请求数据
        String URL = "http://test.vipgift.gmilesquan.com/quMall/common?funid=30101";  // 下单接口
        String result = HttpClientUtil.SendHttpRequest("POST", URL, jsonParameters); // 提交下单请求, 获得响应结果

        logger.info("----------------------------------------------------------------------------");
        logger.info("响应数据 = {}", result);
        logger.info("订单号 = {}", orderId);

        return "订单ID: " + orderId +"\r\n" + ResultUtil.success(result).getData();
    }*/


    /**
     * 通过用户ID 来下单  ,并使用返现红包
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/purchase_user/{userId}") //lmpurchase
    public String PurchaseByUserId2(@PathVariable("userId") long userId) throws IOException {

        String token = AccessToken.getAccessToken(userId); // 获取token
        String jsonParametersRedPack = JsonData.getRedpackListJsonData(token);  // 生成请求数据
        String URL_REDPACK = "http://test.vipgift.gmilesquan.com/quActivity/common?funid=50132";  // 下单接口
        String resultRedPack = HttpClientUtil.SendHttpRequest("POST", URL_REDPACK, jsonParametersRedPack); // 提交下单请求, 获得响应结果
        JsonRedpackBean jsonRedpackBean = JSON.parseObject(resultRedPack, JsonRedpackBean.class);//json字符串转对象

        String orderId = RandomNumbers.getOrder(); // 生成订单号
        String sourceId = SourceIdUtil.getSourceId(); // 随机获取 1 个商品ID   // 585330318155  返125元
        Commodity commodity = commodityService.findCommodityInfo(sourceId); // 查询商品信息 : 返利比例 , 实际价格
        logger.info("-----------------------" + commodity.getCouponFinalPrice() +"," + commodity.getTkRate() + "sourceID: " + sourceId);
        String payment = String.valueOf(commodity.getCouponFinalPrice());
        /** 生成一条阿里妈妈订单数据, 订单id 和 商品id 与30301接口上传值保持一致 **/
        AlimamaOrder alimamaOrder = new AlimamaOrder(new Date(), new Date(), "运动耳机", 525694095950L, "华胜天齐数码专营店", "华胜天齐数码专营店",
                1, "88.00", "订单付款", "天猫", commodity.getTkRate()+" %", "100.00 %", payment, "6.00",
                "0.00", "0.00", commodity.getTkRate()+" %", "0", "0.00 %", "0", "-", "无线",
                "--", orderId,
                "影音电器", "45368612", "趣专享", "23950950016", "趣专享高佣", "953470", new Date(), new Date(), 0);
        alimamaOrderService.saveAlimamaOrder(alimamaOrder);



        if(jsonRedpackBean.getRebateRedpacks().size()>0){
            logger.info("-----------------------红包数量: " + jsonRedpackBean.getRebateRedpacks().size());
            logger.info("-----------------------红包ID: " + jsonRedpackBean.getRebateRedpacks().get(0).getRedpackId());

            // 上传红包信息  33006接口
            String redpackInfo = JsonData.getJsonDataRedPackInfo(token,sourceId);
            String URL_Red = "http://test.vipgift.gmilesquan.com/quMall/common?funid=33006";  // 下单接口
            String result_red = HttpClientUtil.SendHttpRequest("POST", URL_Red, redpackInfo); // 提交下单请求, 获得响应结果
            logger.info("=====响应数据==== = {}", result_red);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            /** 调30301接口上传百川回调数据至用户订单表 **/
            byte bt = 1; //  1: 表示有效账号
            Account account = accountRepository.findById(userId); //  查询用户ID
            if (account == null || "".equals(account)) {
                logger.info("------------------ 返回对象为空");
                return "返回对象为空" + account;
            }
            String jsonParameters = JsonData.getJsonDataRedPack(token,orderId,account.getPrdId(),sourceId,jsonRedpackBean);
            String URL = "http://test.vipgift.gmilesquan.com/quMall/common?funid=30101";  // 下单接口
            String result = HttpClientUtil.SendHttpRequest("POST", URL, jsonParameters); // 提交下单请求, 获得响应结果

            logger.info("----------------------------------------------------------------------------");
            logger.info("响应数据 = {}", result);
            logger.info("订单号 = {}", orderId);
            return "订单ID: " + orderId +"\r\n" + ResultUtil.success(result).getData();

        }else {
            /** 调30301接口上传百川回调数据至用户订单表 **/
            byte bt = 1; //  1: 表示有效账号
            Account account = accountRepository.findById(userId); //  查询用户ID
            if (account == null || "".equals(account)) {
                logger.info("------------------ 返回对象为空");
                return "返回对象为空" + account;
            }
            String jsonParameters = JsonData.getJsonData(token,orderId,account.getPrdId(),sourceId);
            String URL = "http://test.vipgift.gmilesquan.com/quMall/common?funid=30101";  // 下单接口
            String result = HttpClientUtil.SendHttpRequest("POST", URL, jsonParameters); // 提交下单请求, 获得响应结果

            logger.info("----------------------------------------------------------------------------");
            logger.info("响应数据 = {}", result);
            logger.info("订单号 = {}", orderId);
            return "订单ID: " + orderId +"\r\n" + ResultUtil.success(result).getData();
        }

    }


    /**
     * 生成订单号
     *
     * @return
     */
    @GetMapping(value = "/order")
    public String GetOrder() {
        return RandomNumbers.getOrder();
    }

    /**
     * 获取用户信息  根据 tabao_id
     */

    @RequestMapping("/getuserinfo_old/{prdID}/{tbID}")
    @ResponseBody
    public Account getUserOrderByUserId(@PathVariable("tbID") String tbID, @PathVariable("prdID") String prdID) {
        byte bt = 1;
        Account account = accountRepository.findByPrdIdAndTbIdAndStatus(prdID, tbID, bt);
        logger.info("------------------------" + JSON.toJSONString(account, true));
        return account;
    }

    /**
     * 获取用户ID 根据union_id
     */

    @RequestMapping("/getuserinfo/{prdID}/{unionID}")
    @ResponseBody
    public String getUserOrderByUserId2(@PathVariable("unionID") String unionID, @PathVariable("prdID") String prdID) {
        byte bt = 1;
        Account account = accountRepository.findByPrdIdAndUnionIdAndStatus(prdID, unionID, bt);
        logger.info("------------------------" + JSON.toJSONString(account, true));
        return account.getId() + "";
    }
}

