package com.yoodb.study.demo08.bean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    private Lock lock = new ReentrantLock();

    public void testTryLock(Thread thread){
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    System.out.println("线程 " + thread.getName() + " 正在执行！！！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("线程 " + thread.getName() + " 释放了锁！！！");
                    lock.unlock();
                }
            }else {
                System.out.println("线程 " + thread.getName() + " 没有获取到锁！！！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void unlock() {

    }

    public static void main(String[] args){
        for(int i = 0;i < 100 ; i++){
            TestLock testLock = new TestLock();
            Thread a = new Thread("A--" + i) {
                @Override
                public void run() {
                    testLock.testTryLock(Thread.currentThread());
                }
            };
            Thread b = new Thread("B--" + i) {
                @Override
                public void run() {
                    testLock.testTryLock(Thread.currentThread());
                }
            };
            a.start();
            b.start();
        }
    }
}