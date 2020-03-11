package com.yoodb.study.demo04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yoodb.study.demo04.bean.BootUser;
import com.yoodb.study.demo04.service.BootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/myt")
public class BootUserController {
    @Autowired
    private BootUserService service;

    @RequestMapping("/getUsers")
    public List<BootUser> getUsers() {
        List<BootUser> list = service.getUsers();
        return list;
    }

    @GetMapping(value = "/first")
    public Map<String, Object> first (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        StringBuffer requestUrl = request.getRequestURL();
        request.getSession().setAttribute("requestUrl",requestUrl );
        map.put("requestUrl", requestUrl);
        return map;
    }

    @GetMapping(value = "/sessions")
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("requestUrl"));
        return map;
    }

}
