package multi.data.mq;

import multi.data.dao.model.other.RabbitUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 接收消息
 */

@Component
@RabbitListener(queues = "notify.payment")
public class Receiver {
    private final static Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void process(RabbitUser rabbitUser) {
        logger.info("消费者 =============== " + rabbitUser + ":" + new Date());
    }

   /* @RabbitHandler
    public void process(String Str) {
        logger.info("消费者 =============== " + Str + ":" + new Date());
    }*/
}
