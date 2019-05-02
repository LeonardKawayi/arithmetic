package com.daojia.zzk.arithmetic._16dynamicProgramming;

/**
 * @author zhangzk
 * 最大乘积子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class MaxProduct {

    static int maxProduct (int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        int max = 1;
        int min = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(max*nums[i], nums[i]);
            min = Math.min(min*nums[i], nums[i]);
        }

        return Math.max(result, max);
    }

        public static void main(String[] args){
        int[] nums = new int[]{2,3,-1,4};
        int i = maxProduct(nums);
        System.out.println(i);
    }
}
