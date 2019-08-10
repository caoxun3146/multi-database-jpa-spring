package multi.data.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置一个routingKey为notify.payment的消息队列
 */
@Configuration
public class DirectConfig {
   /* @Bean
    public Queue paymentNotifyQueue() {
        return new Queue("notify.payment");
    }*/
}