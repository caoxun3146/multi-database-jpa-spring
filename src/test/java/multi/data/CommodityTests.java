package multi.data;

import com.alibaba.fastjson.JSON;
import multi.data.controller.AccountController;
import multi.data.dao.repo.primary.AccountRepository;
import multi.data.service.service.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityTests {
    @Autowired
    private CommodityService commodityService;

    private final static Logger logger = LoggerFactory.getLogger(CommodityTests.class);

    @Test
    public void getCommodity(){

        logger.info("------------------------" + JSON.toJSONString(commodityService.findCommodityInfo("597497853004"),true));

    }
}
