package com.daojia.zzk.arithmetic.singleton;

/**
 * @author zhangzk
 * 单例模式---内部类
 */
public class Singleton2 {

    static class SingletonHolder {
        public static Singleton2 singleton = new Singleton2();
    }

    private Singleton2 (){}

    public Singleton2 getInstance () {
        return SingletonHolder.singleton;
    }
}
