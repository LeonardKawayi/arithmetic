package com.daojia.zzk.arithmetic.singleton;

/**
 * @author zhangzk
 * 单例模式
 */
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton () {
    }

    /**
     * DCL
     * */
    public static Singleton getSingleton () {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
