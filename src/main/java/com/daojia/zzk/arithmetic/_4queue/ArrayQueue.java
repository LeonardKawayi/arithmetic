package com.daojia.zzk.arithmetic._4queue;

/**
 * @author zhangzk
 * 用数组实现的队列叫作顺序队列
 */
public class ArrayQueue {

    /**
     *  数组items, 数组大小n
     * */
    private String[] items;

    private int n;

    /**
     * head 表示队头下标
     * */
    private int head = 0;

    /**
     * tail表示队尾下标
     * */
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队
     * */
    public boolean enqueue (String item) {
        if (tail == n) {
            return false;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 不停的入队出队，head和tail往后移，当移动到最右侧，数组中就没有空闲空间了。在入队的时候进行一个数据搬移，出队的操作的时间复杂度也是O（1）
     * */
    public boolean enqueue2 (String item) {
        /**
         * tail == n 表示队尾没有空闲空间了
         * */
        if (tail == n) {
            // 如果此时head == 0 表示队列中满了
            if (head == 0) {
                return false;
            }
            // 进行数据搬移
            for (int i = head; i < tail; i++) {
                items[i-head] = items[head];
            }
            // 搬完后重新给head 和tail 赋值
            head = 0;
            tail -=head;
        }

        //然后入队
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     * */
    public String dequeue () {
        /**
         * 如果head==tail表示队列为空
         * */
        if (head == tail) {
            return "";
        }

        String result = items[head];
        ++head;
        return result;
    }

}
