package multi.data.mq;

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

    public String send(String name){
        String context = name;
        logger.info("发送者 -------------------- 消息发送时间："+ new Date());
        amqpTemplate.convertAndSend("notify.payment", context);   // notify.payment  为队列名称
        return "发送成功";
    }
}
