package multi.data.controller;

import com.alibaba.fastjson.JSON;
import multi.data.dao.model.primary.AlimamaOrder;
import multi.data.dao.model.primary.Result;
import multi.data.service.service.AlimamaOrderService;
import multi.data.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlimamaOrderController {
    @Autowired
    AlimamaOrderService alimamaOrderService;

    private final static Logger logger = LoggerFactory.getLogger(AlimamaOrderController.class);

    @RequestMapping("/alimama/{orderId}")
    @ResponseBody
    public Result getUserOrderByUserId(@PathVariable("orderId") String orderId) {
        AlimamaOrder alimamaOrder = alimamaOrderService.findByOrderId(orderId);
        logger.info("------------------>" + JSON.toJSONString(alimamaOrder, true));
        return ResultUtil.success(alimamaOrder);
    }
}
