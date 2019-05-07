package com.daojia.zzk.arithmetic._11heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangzk
 * 数据流中的中位数
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue();
        this.maxHeap = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void addNum(int num) {
        int size = minHeap.size() + maxHeap.size();
        // 一共偶数个
        if ((size & 1) == 0) {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                // 将这个数添加到小顶堆中
                minHeap.offer(num);

                // 小顶堆中数量多了,从小顶堆中取出最小的加入到大顶堆
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        } else {    // 奇数个
            if (!maxHeap.isEmpty() && num < maxHeap.poll()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }

    /**
     * 查找中位数
     * */
    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        if ((size & 1) == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
