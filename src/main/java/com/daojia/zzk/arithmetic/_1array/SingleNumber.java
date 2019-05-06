package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 数组中只出现一次的数字
 * 一个数组中：只有一个数组出现奇数次，其余的数字出现次数均为偶数次
 *
 */
public class SingleNumber {

    public int singleNumber (int[] nums) {
        if (nums.length == 0) return 0;

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^=nums[i];
        }

        return result;
    }
}
