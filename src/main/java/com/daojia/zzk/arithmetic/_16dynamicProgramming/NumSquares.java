package com.daojia.zzk.arithmetic._16dynamicProgramming;

/**
 * @author zhangzk
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class NumSquares {

    /**
     * 动态规划，状态转移方程dp[i] = Math.min(dp[i], dp[i-j*j] + 1)
     * */
    public int numSquares(int n) {
        //利用动态规划 定义长度为n+1的数组 对应索引所对应的数装最少的步数
        int[] dp = new int[n+1];
        dp[0]=0;

        for (int i = 1; i <= n; i++) {
            //先假设到这一步的最大的步数为每次+1
            dp[i]=i;
            //i-j*j>=0 找到最大的j j*j就是i里面最大的完全平方数
            for (int j = 1; i-j*j>=0; j++) {
                //dp[i-j*j]+1 表示d[i-j*j]的步数＋1 1即j*j这个完全平方数
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        return dp[n];
    }
}
