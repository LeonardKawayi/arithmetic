package com.daojia.zzk.arithmetic._4queue;

/**
 * @author zhangzk
 * 数组实现的双端队列
 */
class MyCircularDeque {
    private int[] queue;
    private int front; //头部下一个要插入的位置
    private int rear; //尾部下一个要插入的位置
    private int count; // 队列中数据的个数
    private int totalCount;//队列长度

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.queue        = new int[k];
        this.front        = k - 1;
        this.rear         = 0;
        this.count        = 0;
        this.totalCount   = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())
            return false;
        else{
            this.queue[this.front] = value;                                              // 偏移量增加
            this.front = fixIndex(this.front - 1);
            this.count ++;                                                               // 占用空间
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())
            return false;
        else{
            this.queue[this.rear] = value;                                              // 偏移量增加
            this.rear = fixIndex(this.rear + 1);
            this.count ++;                                                              // 占用空间
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        else{
            this.queue[fixIndex(this.front + 1)] = 0;                                   // 偏移量增加
            this.front = fixIndex(this.front + 1);
            this.count --;                                                              // 占用空间
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        else{
            this.queue[fixIndex(this.rear - 1)] = 0;                                   // 偏移量增加
            this.rear = fixIndex(this.rear - 1);
            this.count --;                                                             // 占用空间
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty())
            return -1;
        return this.queue[fixIndex(this.front + 1)];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;
        return this.queue[fixIndex(this.rear - 1)];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.count == 0 ;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.count == this.totalCount;
    }

    public int fixIndex(int index){
        if(index < 0)
            return index + this.totalCount;
        else if(index >= this.totalCount)
            return index % this.totalCount;
        return index;
    }
}
