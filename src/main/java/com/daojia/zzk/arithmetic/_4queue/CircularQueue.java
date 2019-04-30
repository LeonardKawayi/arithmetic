package com.daojia.zzk.arithmetic._4queue;

/**
 * @author zhangzk
 * 循环队列,最关键的是，确定好队空和队满的判定条件,对空的条件依然是:head == tail;队满的条件是: (tail + 1)%n = head
 */
public class CircularQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head 表示队头下标，tail 表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为 capacity 的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) return "";
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
