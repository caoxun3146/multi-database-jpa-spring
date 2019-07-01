package multi.data.controller;

import com.alibaba.fastjson.JSON;
import multi.data.dao.model.primary.Account;
import multi.data.dao.model.secondary.Award;
import multi.data.dao.repo.primary.AccountRepository;
import multi.data.dao.repo.secondary.AwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AwardRepository awardRepository;

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);
    /**
     * 浏览商品赚现金豆
     */
    @RequestMapping("/award/{phoneId}")
    @ResponseBody
    public List<Award> getUserOrderByUserId(@PathVariable("phoneId") String phoneId) {
        return awardRepository.findByPhoneId(phoneId);
    }
}
