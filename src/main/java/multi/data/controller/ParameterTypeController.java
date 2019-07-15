package multi.data.controller;

import com.alibaba.fastjson.JSON;
import multi.data.dao.model.other.JsonParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 不同参数类型请求
 */
@Controller
public class ParameterTypeController {

    /**
     * json类型参数
     * @param jp
     * @return
     */

    private final static Logger logger = LoggerFactory.getLogger(ParameterTypeController.class);
    @PostMapping(value = "/json")
    @ResponseBody
    public JsonParameter Mjson(@RequestBody JsonParameter jp) {
        logger.info("----------------------- " + jp.getName() + "," + jp.getPassword() + ": " + JSON.toJSONString(jp,true));

        return jp;
    }


/**
 *  表单参数
 */
/*    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setWeight(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }*/
}
