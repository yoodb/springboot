package com.yoodb.study.demo02.service;

import java.util.List;

import com.yoodb.study.demo02.mapper.BootUserMapper;
import com.yoodb.study.demo02.bean.BootUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootUserService {
    
    @Autowired
    private BootUserMapper mapper;
    public List<BootUser> getUsers(){
         return mapper.selectAll();
    }
}