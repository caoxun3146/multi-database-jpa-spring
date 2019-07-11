package multi.data.controller;

import com.alibaba.fastjson.JSON;

import multi.data.dao.model.primary.Account;
import multi.data.dao.model.primary.AlimamaOrder;
import multi.data.dao.model.primary.Settlement;
import multi.data.dao.repo.primary.AccountRepository;
import multi.data.dao.repo.primary.SettlementRepository;
import multi.data.service.service.AlimamaOrderService;
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
     * 订单结算
     *
     * @param tbID
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/settlement/{prdID}/{tbID}/{orderId}")
    public String Settlement(@PathVariable("prdID") String prdID, @PathVariable("tbID") String tbID, @PathVariable("orderId") String orderId) throws IOException, ParseException {
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
        String jsonParameters = JsonData.getJsonData(token, orderId, prdID);  // 生成请求数据
        String URL = "http://test.vipgift.gmilesquan.com/quMall/common?funid=30101";  // 下单接口
        String result = HttpClientUtil.SendHttpRequest("POST", URL, jsonParameters); // 提交下单请求, 获得响应结果

        logger.info("----------------------------------------------------------------------------");
        logger.info("响应数据 = {}", result);
        logger.info("订单号 = {}", orderId);

        return ResultUtil.success(result).getData() + ", OrderID: " + orderId;
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

        /** 生成一条阿里妈妈订单数据, 订单id 和 商品id 与30301接口上传值保持一致 **/
        AlimamaOrder alimamaOrder = new AlimamaOrder(new Date(), new Date(), "运动耳机", 525694095950L, "华胜天齐数码专营店", "华胜天齐数码专营店",
                1, "88.00", "订单付款", "天猫", "30.01 %", "100.00 %", "19.9900", "6.00",
                "0.00", "0.00", "30.01 %", "0", "0.00 %", "0", "-", "无线",
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

        String jsonParameters = JsonData.getJsonData(token, orderId, prdID);  // 生成请求数据
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
    @GetMapping(value = "/purchase_user/{userId}") //lmpurchase
    public String PurchaseByUserId(@PathVariable("userId") long userId) throws IOException {

        String orderId = RandomNumbers.getOrder(); // 生成订单号

        /** 生成一条阿里妈妈订单数据, 订单id 和 商品id 与30301接口上传值保持一致 **/
        AlimamaOrder alimamaOrder = new AlimamaOrder(new Date(), new Date(), "运动耳机", 525694095950L, "华胜天齐数码专营店", "华胜天齐数码专营店",
                1, "88.00", "订单付款", "天猫", "30.01 %", "100.00 %", "19.9900", "6.00",
                "0.00", "0.00", "30.01 %", "0", "0.00 %", "0", "-", "无线",
                "--", orderId,
                "影音电器", "45368612", "趣专享", "23950950016", "趣专享高佣", "953470", new Date(), new Date(), 0);
        alimamaOrderService.saveAlimamaOrder(alimamaOrder);


        /** 调30301接口上传百川回调数据至用户订单表 **/
        byte bt = 1; //  1: 表示有效账号
        Account account = accountRepository.findById(userId); //  查询用户ID
        if (account == null || "".equals(account)) {
            logger.info("------------------ 返回对象为空");
            return "返回对象为空" + account;
        }
        String token = AccessToken.getAccessToken(account.getId()); // 获取token

        String jsonParameters = JsonData.getJsonData(token, orderId, account.getPrdId());  // 生成请求数据
        String URL = "http://test.vipgift.gmilesquan.com/quMall/common?funid=30101";  // 下单接口
        String result = HttpClientUtil.SendHttpRequest("POST", URL, jsonParameters); // 提交下单请求, 获得响应结果

        logger.info("----------------------------------------------------------------------------");
        logger.info("响应数据 = {}", result);
        logger.info("订单号 = {}", orderId);

        return ResultUtil.success(result).getData() + ", OrderID: " + orderId;
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
     * 获取用户信息
     */

    @RequestMapping("/getuserinfo/{prdID}/{tbID}")
    @ResponseBody
    public Account getUserOrderByUserId(@PathVariable("tbID") String tbID, @PathVariable("prdID") String prdID) {
        byte bt = 1;
        Account account = accountRepository.findByPrdIdAndTbIdAndStatus(prdID, tbID, bt);
        logger.info("------------------------" + JSON.toJSONString(account, true));
        return account;
    }
}

