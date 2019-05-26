package com.daojia.zzk.arithmetic._9hash;

/**
 * @auhtor zhangzk
 */
public class CacheNode {
    Object key;
    Object value;
    CacheNode prev;
    CacheNode next;

    public CacheNode(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
