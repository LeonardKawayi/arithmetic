package com.daojia.zzk.arithmetic._11heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhangzk
 * 查找数组中第k大元素,你需要找的是数组排序后的第 k 个最大的元素
 */
public class FindKthLargest {
    /**
     *  小顶堆实现方法
     *  时间复杂度 O(NlogK)，空间复杂度 O(K)
     * */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

    /**
     * 排序方式
     * */
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     *
     * */
}
