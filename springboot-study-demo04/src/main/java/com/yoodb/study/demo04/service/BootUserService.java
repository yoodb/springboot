package com.yoodb.study.demo04.service;

import java.util.List;

import com.yoodb.study.demo04.bean.BootUser;
import com.yoodb.study.demo04.mapper.BootUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BootUserService {

    @Autowired
    private BootUserMapper bootUserMapper;

   @Autowired
    private RedisTemplate redisTemplate;

    public List<BootUser> getUsers(){
        List<BootUser> bootUsers = bootUserMapper.selectAll();
        redisTemplate.opsForValue().set("bootUsers",bootUsers);
        List<BootUser> list = (List<BootUser>)redisTemplate.opsForValue().get("bootUsers");
        return list;
    }

}