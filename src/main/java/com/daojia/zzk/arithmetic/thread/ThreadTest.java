package com.daojia.zzk.arithmetic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程调度
 * 两个线程
 * 一个只能存有数组 1、3、5 和另一个存有 2、4、6，然后通过调度，最终结果输出 123456
 */
public class ThreadTest {

    private static Object object = new Object();
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            lock.lock();

            for (int i = 1; i <= 5 ; i+=2) {
                System.out.println(i);
                try {
                    condition1.await();
                    condition2.signal();
                } catch (InterruptedException e) {

                }
            }
            lock.unlock();
        });

        Thread thread2 = new Thread(() -> {
            lock.lock();

            for (int i = 2; i <= 6 ; i+=2) {
                System.out.println(i);
                try {
                    condition1.signal();
                    condition2.await();
                } catch (InterruptedException e) {

                }
            }
            lock.unlock();
        });

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
