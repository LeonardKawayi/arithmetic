package com.daojia.zzk.arithmetic._16dynamicProgramming;

/**
 * 0-1背包问题升级
 * 现在引入物品价值,要求满足背包重量最大的前提下,背包中可装入物品的总价值最大。
 */
public class Package01Update {

    /**
     * 回溯实现
     * */
    private int maxV = Integer.MIN_VALUE;
    private int[] weight = {2,2,4,6,3};
    private int[] value = {3,4,8,9,6};
    // 物品个数
    private int n = 5;
    // 背包承受总重量
    private int w = 9;

    private void f (int i, int cw, int cv) {
        if (cw == w || i >= n) {
            if (cv >= maxV) {
                maxV = cv;
            }
            return;
        }

        // 第i个不放入背包
        f(i+1, cw, cv);
        if (cw + weight[i] <= w) {
            // 第i个放入背包
            f(i+1, cw+weight[i], cv+value[i]);
        }
    }

    /**
     * 动态规划实现
     * weight: 物品重量数组， value：物品价值数组， n:一共n个物品， w：背包最大重量
     * 时间复杂度是 O(n*w)，空间复杂度也是 O(n*w)
     * */
    public int knapsack3 (int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w+1; j++) {
                states[i][j] = -1;
            }
        }

        states[0][weight[0]] = 0;
        for (int i = 0; i < n; i++) {
            // 不选择第i个物品
            for (int j = 0; j < w+1; j++) {
                if (states[i-1][j] >= 0) {
                    states[i][j] = states[i-1][j];
                }
            }

            // 选择第i个物品
            for (int j = 0; j < w-weight[i]; j++) {
                if (states[i-1][j] >= 0) {
                    int newValue=states[i-1][j] + value[i];
                    if (newValue > states[i][j+weight[i]]) {
                        states[i][j+weight[i]]=newValue;
                    }
                }
            }
        }

        // 最大值
        int maxValue = -1;
        for (int j = 0; j < w+1; j++) {
            if (states[n-1][j] > maxValue) {
                maxValue = states[n-1][j];
            }
        }

        return maxValue;
    }


}
