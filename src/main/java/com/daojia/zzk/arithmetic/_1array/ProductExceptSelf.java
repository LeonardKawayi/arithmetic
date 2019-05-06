package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {

    /**
     * 走两遍，用两个数组left和right记录左右数字的乘积
     * */
    public int[] productExceptSelf (int[] nums) {
        int left = 1;
        int right = 1;

        int n = nums.length;
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            output[i] = left;
            left *=nums[i];
        }

        for (int j = n-1; j >=0 ; j--) {
            output[j] *= right;
            right *=nums[j];
        }

        return output;
    }
}
