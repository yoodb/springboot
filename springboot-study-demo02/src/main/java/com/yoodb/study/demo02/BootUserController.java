package com.yoodb.study.demo02;

import java.util.List;

import com.yoodb.study.demo02.service.BootUserService;
import com.yoodb.study.demo02.bean.BootUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
