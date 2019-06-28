package multi.data;

import com.alibaba.fastjson.JSON;
import multi.data.controller.AccountController;
import multi.data.dao.model.primary.Account;
import multi.data.dao.repo.primary.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTests {

    /**
     * 新增注释
     */
    @Autowired
    private AccountRepository accountRepository;

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Test
    public void getUserInfo(){
        Account account = accountRepository.findByTbId("1953957034");
        logger.info("====================" );
        logger.info("-----------------------" + JSON.toJSONString(account, true));
    }
}
