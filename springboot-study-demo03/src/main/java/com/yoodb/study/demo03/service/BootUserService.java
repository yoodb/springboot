package com.yoodb.study.demo03.service;

import com.yoodb.study.demo03.mapper.two.BootUserTwoMapper;
import com.yoodb.study.demo03.bean.BootUser;
import com.yoodb.study.demo03.mapper.one.BootUserOneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BootUserService {
    
    @Autowired
    private BootUserOneMapper onemapper;

    @Autowired
    private BootUserTwoMapper twomapper;

    public List<BootUser> getUsers(){
        List<BootUser> listone = onemapper.selectAll();
        List<BootUser> listtwo = twomapper.selectAll();
        listone.addAll(listtwo);
        return listone;
    }
}