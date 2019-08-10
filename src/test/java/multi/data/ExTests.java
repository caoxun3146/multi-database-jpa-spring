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

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class ExTests extends AccountTests {  // extends AccountTests

    //private final static Logger logger = LoggerFactory.getLogger(AccountTests.class);
    @Autowired
    private AccountRepository accountRepository;
    @Test
    public void exTest (){
        byte bt = 1 ;
        Account account = accountRepository.findByPrdIdAndTbIdAndStatus("14000","1953957034",bt);
        //logger.info("-----------------------" + JSON.toJSONString(account, true));
        this.setStr("ExTests.class");
        this.getLogger().info("1====================" );
        this.getLogger().info("2-----------------------" + JSON.toJSONString(account, true));

        this.getUserInfo();
    }

}
