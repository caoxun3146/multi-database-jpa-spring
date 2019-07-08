package multi.data.controller;

import com.alibaba.fastjson.JSONObject;
import multi.data.utils.SendPush;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PushController {
    /**
     * 根据设备ID  推送  ,默认性别:女(1)  男(0)
     *
     * @param jsession
     * @param phoneId
     * @return
     * @throws IOException
     */
    private final static Logger logger = LoggerFactory.getLogger(PushController.class);

    @GetMapping(value = "/push/{jsession}/{phoneId}")
    public String Push(@PathVariable("jsession") String jsession, @PathVariable("phoneId") String phoneId) throws IOException {

        String result = SendPush.send(jsession, phoneId, "1");  // 设置性别为女
        JSONObject pa = JSONObject.parseObject(result);
        logger.info("------------------> " + pa.getString("msg"));
        if (pa.getString("msg").equals("未找到推送的设备ID列表")) {
            result = SendPush.send(jsession, phoneId, "0");   // 设置性别为男
        }
        return result;
    }

}
