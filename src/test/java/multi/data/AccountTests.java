package multi.data;

import com.alibaba.fastjson.JSON;
import multi.data.controller.AccountController;
import multi.data.dao.model.other.redpacks.JsonRedpackBean;
import multi.data.dao.model.primary.Account;
import multi.data.dao.repo.primary.AccountRepository;
import multi.data.utils.AccessToken;
import multi.data.utils.HttpClientUtil;
import multi.data.utils.JsonData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTests {

    /**
     * 新增注释
     */
    @Autowired
    private AccountRepository accountRepository;

    //private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    private   Logger logger = LoggerFactory.getLogger(AccountController.class);

    private String str ;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.logger =  LoggerFactory.getLogger(str);
    }

    public Logger getLogger() {
        return logger;
    }


    @Test
    public void getUserInfo(){
        byte bt = 1 ;
        Account account = accountRepository.findByPrdIdAndTbIdAndStatus("14000","1953957034",bt);
        logger.info("====================" );
        logger.info("-----------------------" + JSON.toJSONString(account, true));
    }

    /**
     * 请求返现红包接口,  获得返现红包记录
     */
    @Test
    public void redPack(){
        long userid = 9457603;
        String token = AccessToken.getAccessToken(userid); // 获取token
        String jsonParameters = JsonData.getRedpackListJsonData(token);  // 生成请求数据
        String URL = "http://test.vipgift.gmilesquan.com/quActivity/common?funid=50132";  // 下单接口
        try {
            String result = HttpClientUtil.SendHttpRequest("POST", URL, jsonParameters); // 提交下单请求, 获得响应结果
            JsonRedpackBean jsonRedpackBean = JSON.parseObject(result, JsonRedpackBean.class);//json字符串转对象
            // 判断红包列表下发 红包数量 是否为空
            if(jsonRedpackBean.getRebateRedpacks().size()>0){
                logger.info("-----------------------红包数量: " + jsonRedpackBean.getRebateRedpacks().size());
                logger.info("-----------------------红包ID: " + jsonRedpackBean.getRebateRedpacks().get(0).getRedpackId());


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
