package multi.data;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;
    private final static Logger logger = LoggerFactory.getLogger(RedisTest.class);
    private JSONObject json = new JSONObject();

    /**
     * 获取字符串
     */
    @Test
    public void getString() {
        Object result = redisTemplate.opsForValue().get("AccountProviderImpl:getDeviceData_v3:0001301_1");
        logger.info("----------------------" + result.toString());
    }

}
