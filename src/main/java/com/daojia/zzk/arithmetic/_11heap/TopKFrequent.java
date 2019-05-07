package com.daojia.zzk.arithmetic._11heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhangzk
 * 前K个高频元素
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 小顶堆实现
 */
public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        PriorityQueue<Frequent> queue = new PriorityQueue<>(k, new Comparator<Frequent>() {
            @Override
            public int compare(Frequent o1, Frequent o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (Integer integer : map.keySet()) {
            Integer fre = map.get(integer);
            Frequent frequent = new Frequent(integer, fre);
            queue.add(frequent);
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().val);
        }

        return list;
    }


    static class Frequent {
        int val;
        int frequent;

        public Frequent(int val, int frequent) {
            this.val = val;
            this.frequent = frequent;
        }
    }
}
