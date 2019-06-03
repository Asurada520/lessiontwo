package com.ybzbcq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class IndexController {

    // logback
    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model){

        logger.info("IndexController -> 访问了index方法.");
        logger.error("IndexController -> 记录error错误日志.");
        logger.debug("IndexController -> 记录debug错误日志.");
        model.addAttribute("name", "liya");
        return "index";
    }

    @RequestMapping(value = "/loginView", method = RequestMethod.GET)
    public String loginView(){
        return "login";
    }

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map){
        map.put("name", "liya");
        return "hello";
    }

    @RequestMapping("map")
    public String goDistance(){
        return "distance";
    }
}
