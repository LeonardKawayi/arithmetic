package com.daojia.zzk.arithmetic._16dynamicProgramming;

import com.daojia.zzk.arithmetic._1array.Array;

import java.util.Arrays;

/**
 * @author zhangzk
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 */
public class CoinChange {

    int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    int coinChange2 (int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount+1];
        for (int i = 0; i <= amount ; i++) {
            if (coins[i] < amount) {
                dp[coins[i]] = 1;
            } else if (coins[i] == amount) {
                return 1;
            }
        }

        for (int i = 1; i <=amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i-coins[j]]==0) {
                        continue;
                    }

                    if (dp[i] != 0) {
                        dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
                    } else {
                        dp[i]=dp[i-coins[j]]+1;
                    }
                }
            }
        }

        if (dp[amount] == 0) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
