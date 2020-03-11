package com.yoodb.study.demo02.mapper;

import com.yoodb.study.demo02.bean.BootUser;

import java.util.List;

public interface BootUserMapper {

    List<BootUser> selectAll();
}