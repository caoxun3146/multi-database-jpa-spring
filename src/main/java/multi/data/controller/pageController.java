package multi.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller  //注意这里必须为Controller
public class pageController {

    @RequestMapping("/hello/{tbID}")
    public String helloHtml(HashMap<String, Object> map, @PathVariable("tbID") String tbID) {
        map.put("hello", "欢迎进入HTML页面");
        System.out.println("---------------" + tbID);
        return "index"; // "/index" 改成 "index" java -jar xx   才能访问得到
    }
}
