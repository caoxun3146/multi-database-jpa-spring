package multi.data.controller;

import com.alibaba.fastjson.JSON;
import multi.data.dao.model.primary.Account;
import multi.data.dao.repo.primary.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);
    /**
     * 获取用户信息
     */
    @RequestMapping("/getuserinfo/{prdID}/{tbID}")
    @ResponseBody
    public Account getUserOrderByUserId(@PathVariable("tbID") String tbID, @PathVariable("prdID") String prdID) {
        byte bt = 1;
        Account account = accountRepository.findByPrdIdAndTbIdAndStatus(prdID, tbID, bt);
        logger.info("------------------------" + JSON.toJSONString(account, true));
        return account;
    }
}
