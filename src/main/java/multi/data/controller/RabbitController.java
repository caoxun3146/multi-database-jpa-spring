package multi.data.controller;

import multi.data.dao.service.mq.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {
    private final static Logger logger = LoggerFactory.getLogger(RabbitController.class);

    @Autowired
    private Sender sender;

    @GetMapping(value = "/sender/{name}")
    public String sender(@PathVariable("name") String name){
        sender.send(name);
        return "success";
    }
}
