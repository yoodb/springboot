package com.yoodb.study.demo04.mapper;

import com.yoodb.study.demo04.bean.BootUser;

import java.util.List;

public interface BootUserMapper {

    List<BootUser> selectAll();
}