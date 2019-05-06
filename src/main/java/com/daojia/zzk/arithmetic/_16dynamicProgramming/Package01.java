package com.daojia.zzk.arithmetic._16dynamicProgramming;

/**
 * @author zhangzk
 * 0-1背包问题的求解
 */
public class Package01 {
    /**
     * 回溯算法实现0-1背包问题。注意：我把输入的变量都定义成了成员变量。
     * 递归树中每个节点表示一种状态，用(i, cw)表示，i表示将要角色第i个物品是都装入背包，cw表示背包中物品的总重量。
     *（2，2）表示我们要决策第二个物品是否要装入背包，在决策前，背包中的总重量是2.
     * 有些节点是重复的，比如（2，2）和（3，4）
     * 时间复杂度O(2^n)
     * */
    private int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private int[] weight = new int[]{2,2,4,6,3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    public void f1(int i, int cw) { // 调用 f(0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        f1(i + 1, cw); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f1(i + 1, cw + weight[i]); // 选择装第 i 个物品
        }
    }

    /**
     * 基于回溯算法节点重复的问题，引入备忘录。我们用备忘录来记录已经计算好的f(i, cw)。
     * 再次计算重复的f(i, cw)时，可以直接从备忘录中取出，不用再递归计算了，避免冗余计算。
     * */
    private boolean[][] mem = new boolean[5][10]; // 备忘录，默认值 false
    public void f2(int i, int cw) { // 调用 f2(0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
        if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return; // 重复状态

        mem[i][cw] = true; // 记录 (i, cw) 这个状态
        f2(i+1, cw); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f2(i+1,cw + weight[i]); // 选择装第 i 个物品
        }
    }

    /**
     * 动态规划法求解
     * weight: 物品重量，n: 物品个数，w: 背包可承载重量
     * 时间复杂度O（n*w）
     * 需要额外申请一个n*(w+1)的二维数组,对空间消耗比较大。
     * */
    public int knapsack (int[] weight, int n, int w) {
        // 默认值 false
        boolean[][] states = new boolean[n][w+1];
        // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][0] = true;
        states[0][weight[0]] = true;
        // 动态规划状态转移
        for (int i = 0; i < n; i++) {
            // 不把第 i 个物品放入背包, j表示当前放入背包中的重量
            for (int j = 0; j <= w; j++) {
                if (states[i-1][j]) {
                    states[i][j] = states[i-1][j];
                }
            }

            // 把第 i 个物品放入背包
            for (int j = 0; j < w-weight[i]; j++) {
                if (states[i-1][j]) {
                    states[i][j+weight[i]] = true;
                }
            }
        }
        // 输出结果
        for (int j = w; j >= 0; j--) {
            if (states[n-1][j]) {
                return j;
            }
        }
        return 0;
    }

    /**
     * 动态规划法求解
     * knapsack方法空间复杂度是O（n*w）
     * 只申请一个一维数组解决
     * weight: 物品重量，n: 物品个数，w: 背包可承载重量
     * */
    public int  knapsack2 (int[] weight, int n, int w) {
        boolean[] states = new boolean[w+1];
        states[weight[0]]=true;

        // 动态规划
        for (int i = 0; i < n; i++) {
            // 不把第 i 个物品放入背包, j表示当前放入背包中的重量
            for (int j = w-weight[i]; j >=0 ; --j) {
                if (states[j]) states[j+weight[i]]=true;
            }
        }

        for (int j = w; j >=0 ; --j) {
            if (states[j]) return j;
        }

        return 0;
    }



}
