package com.yoodb.study.demo05.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="boot_user")
public class BootUser implements Serializable {
    @Id
    //strategy=GenerationType.IDENTITY 自增长
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private String id;

    @Column(name="user_name")
    private String name;

    @Column(name="detail")
    private String detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}