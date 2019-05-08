package com.daojia.zzk.arithmetic._16dynamicProgramming;

import java.util.Arrays;

/**
 * @author zhangzk
 * 最长上升子序列
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LengthOFLIS {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
