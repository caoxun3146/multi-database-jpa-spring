package multi.data;

import com.alibaba.fastjson.JSON;
import multi.data.dao.model.primary.WhileList;
import multi.data.service.service.WhileListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhileListTests {

    @Autowired
    private WhileListService whileListService;

    private final static Logger logger = LoggerFactory.getLogger(WhileListTests.class);

    @Test
    public void getWhileList(){
        WhileList whileList = whileListService.fingByKey("zero_shop_while_list_phone_id");
        logger.info("========================" + whileList.getValue());
        logger.info("------------------------" + JSON.toJSONString(whileListService.fingByKey("zero_shop_while_list_phone_id"),true));
    }

    @Test
    public void saveValue(){
        WhileList whileList = whileListService.fingByKey("zero_shop_while_list_phone_id");
        logger.info("========================" + JSON.toJSONString(whileListService.fingByKey("zero_shop_while_list_phone_id"),true));
//        String value = whileList.getValue() + ",1111111111";
 //       whileList.setValue(value);
        //设备白名单
        whileList.setComment("设备白名单1");
        //whileList.setCreateTime(new Date());
        logger.info("==========================66=" + whileList.getComment());
        whileListService.updateWhileList(whileList);
    }
}
