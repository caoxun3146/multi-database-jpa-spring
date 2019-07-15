package multi.data;

import multi.data.dao.model.other.RabbitUser;
import multi.data.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTests {
    private final static Logger logger = LoggerFactory.getLogger(RabbitMqTests.class);

    @Autowired
    private Sender sender;

    @Test
    public void SenderDemo(){
        RabbitUser rabbitUser = new RabbitUser("张三","pass123456");
        sender.send(rabbitUser);
    }
}
