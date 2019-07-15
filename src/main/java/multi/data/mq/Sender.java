package multi.data.mq;

import multi.data.dao.model.other.RabbitUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送消息
 */

@Component
public class Sender {
    private final static Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(RabbitUser rabbitUser){
        logger.info("发送者 ------------------------------ 发送时间："+ new Date());
        amqpTemplate.convertAndSend("notify.payment", rabbitUser);   // notify.payment  为队列名称
        return "发送成功";
    }

    /*public String send(String name){
        String context = name;
        logger.info("发送者 ------------------------------ 发送时间："+ new Date());
        amqpTemplate.convertAndSend("notify.payment", context);   // notify.payment  为队列名称
        return "发送成功";
    }*/
}
