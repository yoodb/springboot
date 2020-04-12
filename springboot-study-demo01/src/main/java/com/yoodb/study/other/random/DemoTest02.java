package com.yoodb.study.other.random;

public class DemoTest02 {
    public static void main(String[]args){
        int rand = (int)(Math.random()*100000000);
        System.out.println("生成一个8位的随机整数：" + rand);
    }
}
