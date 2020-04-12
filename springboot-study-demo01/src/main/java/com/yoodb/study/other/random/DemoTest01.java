package com.yoodb.study.other.random;

public class DemoTest01 {
    public static void main(String[]args){
        System.out.println("通过Math.random产生的随机数列[关注微信公众号“Java精选”]：");
        for (int j = 0; j < 8; j++) {
            System.out.print(Math.random() + ",");
        }
    }
}
