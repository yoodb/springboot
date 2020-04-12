package com.yoodb.study.demo05.repository;

import com.yoodb.study.demo05.entity.BootUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BootUser, Integer> {

}