package multi.data.controller;

import com.alibaba.fastjson.JSON;
import multi.data.dao.model.other.JsonParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
        logger.info("----------------------- " + JSON.toJSONString(jp,true));
        return jp;
    }


/**
 *  表单参数
 */
    @PostMapping(value = "/form")
    @ResponseBody
    public JsonParameter form(@RequestParam("name") String name,
                        @RequestParam("password") String password) {
                JsonParameter jsonParameter = new JsonParameter();
                jsonParameter.setName(name);
                jsonParameter.setPassword(password);
                logger.info("-----------------------" + JSON.toJSONString(jsonParameter,true));
        return jsonParameter;
    }
}
