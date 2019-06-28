package multi.data;

import com.alibaba.fastjson.JSON;
import multi.data.controller.AccountController;
import multi.data.dao.model.secondary.Award;
import multi.data.dao.repo.secondary.AwardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AwartTests {
    @Autowired
    AwardRepository awardRepository;

    private final static Logger logger = LoggerFactory.getLogger(AwartTests.class);

    @Test
    public void getAwardInfo(){
        List<Award> awardList = awardRepository.findByPhoneId("0776f3c9876341ad");
        logger.info("-----------------------" + JSON.toJSONString(awardList, true));
    }
}
