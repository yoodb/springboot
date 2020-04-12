package com.yoodb.study.other.random;

import java.util.Random;

public class DemoTest03 {
    public static void main(String[]args){
        for(int i = 0; i < 2; i++){
            System.out.println("执行第" + (i+1) + "次");
            Random random = new  Random();
            for(int j = 0; j < 3; j++) {
                System.out.println("生成[0-50)的整数值为：" + random.nextInt(50));
            }
        }
    }
}
