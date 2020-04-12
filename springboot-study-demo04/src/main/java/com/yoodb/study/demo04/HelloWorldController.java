package com.yoodb.study.demo04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
   
@RestController
public class HelloWorldController {
   
    protected static Logger logger=LoggerFactory.getLogger(HelloWorldController.class);
       
    @RequestMapping("/")  
    public String helloworld(){  
        logger.debug("关注微信公众号“Java精选”，Spring Boot系列文章持续更新中，带你从入门到精通，玩转Spring Boot框架。");
        return "Hello world!";  
    }  
       
    @RequestMapping("/hello/{name}")  
    public String helloName(@PathVariable String name){  
        logger.debug("访问 helloName,Name={}",name);  
        return "Hello "+name;  
    }  
}