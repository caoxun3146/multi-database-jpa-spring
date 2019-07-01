package multi.data;

import com.alibaba.fastjson.JSON;
import multi.data.dao.repo.tertiary.TertiaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalanceTests {
    @Autowired
    TertiaryRepository tertiaryRepository;

    private final static Logger logger = LoggerFactory.getLogger(BalanceTests.class);

    @Test
    public void getBalanceInfo(){
        logger.info("-----------------------" + JSON.toJSONString(tertiaryRepository.findByUserId(662519), true));

    }
}
