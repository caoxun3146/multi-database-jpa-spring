package multi.data.controller;

import com.alibaba.fastjson.JSON;
import multi.data.dao.model.primary.UserOrder;
import multi.data.service.service.UserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;
    private final static Logger logger = LoggerFactory.getLogger(UserOrderController.class);

    @RequestMapping("/userorder/{UserId}")
    @ResponseBody
    public List getUserOrderByUserId(@PathVariable("UserId") Long userId) {

        List<UserOrder> userOrder = userOrderService.findByUserId(userId);
        logger.info("------------------------" + userOrder.size());
        logger.info("------------------------" + JSON.toJSONString(userOrder, true));
        return userOrder;
    }

}
