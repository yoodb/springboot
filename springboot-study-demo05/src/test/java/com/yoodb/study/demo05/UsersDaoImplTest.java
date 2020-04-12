package com.yoodb.study.demo05;

import com.yoodb.study.demo05.repository.UserRepository;
import com.yoodb.study.demo05.entity.BootUser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
public class UsersDaoImplTest  {
    @Autowired
    private UserRepository userRepository;

    /**
     * 添加用户
     */
    @Test
    @Transactional// 在测试类对于事务提交方式默认的是回滚。
    @Rollback(false)//取消自动回滚
    public void testInsertUsers(){
        BootUser users = new BootUser();
        users.setName("关注微信公众号“Java精选”");
        users.setDetail("Spring Boot从入门到精通系列文章持续更新中，带你从入门到精通，玩转Spring Boot框架。");
        this.userRepository.save(users);
    }
    
}