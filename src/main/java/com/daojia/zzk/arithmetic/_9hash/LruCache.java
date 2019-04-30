package com.daojia.zzk.arithmetic._9hash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangzk
 * */
public class LruCache {

    //缓存的数量限制
    private int cacheSize;
    //当前的缓存数量
    private int currentSize;
    //所有节点，使用线程安全的Map
    private ConcurrentHashMap nodes;
    //头节点
    private CacheNode head;
    //尾节点
    private CacheNode tail;

    //双向链接节点
    class CacheNode {
        Object key;
        Object value;
        //前一个节点
        CacheNode prev;
        //后一个节点
        CacheNode next;

        CacheNode() {

        }
    }

    public LruCache(int size) {
        this.cacheSize = size;
        this.currentSize = 0;
        nodes = new ConcurrentHashMap(size);
    }

    //插入数据
    public void put(Object key, Object value) {
        //先查询是否已存在该key,存在的话更新value，不存在的花创建一个Node并插入链表
        CacheNode node = (CacheNode) nodes.get(key);
        if (node == null) {
            node = new CacheNode();
        }
        node.key = key;
        node.value = value;

        //若缓存已满则删除末端节点
        if (currentSize >= cacheSize && head != null) {
            removehead();
        }

        if (currentSize == 0) {
            //若只有一个节点，该节点即是头也是尾
            head = node;
            tail = node;
        } else {
            node.next = tail;
            tail.prev = node;
            tail = node;
        }

        currentSize ++;
        nodes.put(key, node);
    }

    //查询数据＠key
    public Object get(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node != null) {
            //查询成功后将该节点移到链表头部
            moveToHead(node);
            return node;
        }

        return null;
    }

    //移除数据＠key
    public void remove(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        System.out.println("remove:node = " + node.value);
        //System.out.println("remove:node.prev = " + node.prev.value);
        //System.out.println("remove:node.next = " + node.next.value);
        if (node != null) {
            if (currentSize == 1) {
                //若只有一条数据，不需要维护链表，直接清空即可
                clear();
            } else {
                if (node == tail) {
                    //移除的是头节点
                    if (node.next != null) node.next.prev = null;
                    tail = node.next;
                    node.next = null;
                } else if (node == head) {
                    //移除的是尾节点
                    if (node.prev != null) node.prev.next = null;
                    head = node.prev;
                    node.prev = null;
                } else {
                    //移除的是中间的节点
                    node.prev.next = node.next;
                    node.next.prev = node.prev;

                    node.prev = null;
                    node.next = null;
                }
                currentSize --;
                nodes.remove(key);
            }
        }
    }

    public void clear() {
        nodes.clear();
    }

    //移除末端节点
    public void removehead() {
        System.out.println("removehead:head = " + head.value);
        Object obj = nodes.remove(head.key);
        if (obj != null) currentSize --;

        if (head != null) {
            if (head.prev != null)head.prev.next = null;
            head = head.prev;
            //head.prev = null;

        }
    }

    //将最近访问的节点＠node移到链表头部
    public void moveToHead(CacheNode node) {
        System.out.println("moveToHead:node = " + node.value);
        //System.out.println("moveToHead:node.prev = " + node.prev.value);
        //System.out.println("moveToHead:node.next = " + node.next.value);
        if (node == tail) return;
        if (node == head) {
            //将尾节点移到头部
            node.prev.next = null;
            head = node.prev;
            node.prev = null;

            node.next = tail;
            tail.prev = node;
            tail = node;
        } else {
            //将中间节点移到头部
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = null;
            node.next = tail;

            tail.prev = node;

            tail = node;
        }

    }

    //查看链表数据
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CacheNode node = tail; node != null; node = node.next) {
            sb.append(node.key).append(" " + node.value).append("\n");
        }

        return sb.toString();
    }
}
