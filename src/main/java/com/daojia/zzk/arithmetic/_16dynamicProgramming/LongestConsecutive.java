package com.daojia.zzk.arithmetic._16dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzk
 * 最长连续序列
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {
    int res = Integer.MIN_VALUE;

    /**
     * 并查集方式
     * */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }

            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int len = left + right + 1;

            res = Math.max(res, len);
            map.put(num, 1);
            map.put(num-left, len);
            map.put(num+right, left);
        }

        return res;
    }
}
