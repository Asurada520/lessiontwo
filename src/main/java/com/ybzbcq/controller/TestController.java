package com.ybzbcq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){

//        System.out.println("Test");
        logger.info("TestController ->> 访问 test 方法 .");
        logger.error("TestController ->> 记录  error 日志 . ");
        logger.debug("TestController ->> 访问 debug 日志 . ");

        return "test";
    }
}
