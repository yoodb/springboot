package com.yoodb.study.demo01;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    /**
     * 修改文件
     *
     * @return
     */
    @RequestMapping("/hello")
    public String index() {
        return "关注微信公众号“Java精选”，Spring Boot系列文章持续更新中，带你从入门到精通，玩转Spring Boot框架。";
    }
}