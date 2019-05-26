package com.daojia.zzk.arithmetic._9hash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangzk
 */
public class LruCache2 {
    private int cacheSize;
    private int currentSize;
    // 用ConcurrentHashMap存储Cachenode
    private ConcurrentHashMap nodes;
    // 链表头节点
    private CacheNode head;
    // 缓存链表为节点
    private CacheNode tail;

    public LruCache2(int cacheSize) {
        this.cacheSize = cacheSize;
        currentSize = 0;
        nodes = new ConcurrentHashMap(cacheSize);
    }

    public void put (Object key, Object value) {
        CacheNode node =(CacheNode) nodes.get(key);
        if (node == null) {
            node = new CacheNode(key, value);
        }
        if (currentSize >= cacheSize && tail != null) {
            removeTail();
        }

        if (currentSize == 0 && head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        nodes.put(key, node);
        currentSize++;
    }

    public Object get (Object key) {
        CacheNode node =(CacheNode) nodes.get(key);
        if (node != null) {
            moveToHead(node);
            return node;
        }
        return null;
    }

    public void remove (Object key) {
        CacheNode node =(CacheNode) nodes.get(key);
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (tail == node) {
                tail = node.prev;
            }
            if (head == node) {
                head = node.next;
            }
        }
        nodes.remove(key);
        currentSize--;
    }

    public void clear () {
        nodes.clear();
        head = null;
        tail = null;
        currentSize = 0;
    }

    private void removeTail () {
        if (tail != null) {
            if (tail.prev != null) {
                tail.prev.next = null;
            } else {
                head = null;
            }
            tail = tail.prev;
        }
    }

    private void moveToHead (CacheNode node) {
        if (node == head) return;
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (tail == node) {
            removeTail();
        }

        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        node.prev = null;
        if (tail == null) {
            tail = head;
        }
    }
}
