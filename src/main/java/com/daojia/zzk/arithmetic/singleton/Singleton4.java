package com.daojia.zzk.arithmetic.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhangzk
 * 单例模式---cas
 */
public class Singleton4 {
    private static final AtomicReference<Singleton4> INSTANCE = new AtomicReference<>();
    private Singleton4(){}

    public static final Singleton4 getInstance () {
        for(;;) {
            Singleton4 current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new Singleton4();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }
}
