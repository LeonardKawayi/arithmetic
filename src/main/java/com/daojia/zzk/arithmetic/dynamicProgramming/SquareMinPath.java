package com.daojia.zzk.arithmetic.dynamicProgramming;

/**
 * 动态规划2--原理例子：正方形方格，从左上角出发，到右下角最短路径
 */
public class SquareMinPath {
    private int minDistance = Integer.MAX_VALUE;

    /**
     * 回溯算法实现
     * i: 当前第i行
     * j：当前第j列
     * dist：当前行进的总路程
     * w: 正方形表格每一步距离
     * n: 方形共多少格
     * */
    private void minDist (int i, int j, int dist, int[][] w, int n) {
        if (i == n && j == n) {
            if (dist < minDistance) {
                minDistance = dist;
            }
            return;
        }

        //向下走
        if (i < n) {
            minDist(i+1, j, dist+w[i][j], w, n);
        }

        //向右走
        if (j < n) {
            minDist(i, j+1, dist+w[i][j], w, n);
        }
    }

    /**
     * 动态规划法
     * 状态转移表
     * */
    public int minDist2 (int[][] mastrix, int n) {
        int[][] states = new int[n][n];

        int sum = 0;
        // 初始化第一行
        for (int i = 0; i < n; i++) {
            sum += mastrix[0][i];

            states[0][i] = sum;
        }

        sum=0;
        // 初始化第一列
        for (int j = 0; j < n; j++) {
            sum +=mastrix[j][0];

            states[j][0]=sum;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = mastrix[i][j] + Math.min(states[i-1][j], states[i][j-1]);
            }
        }

        return states[n-1][n-1];
    }


    /**
     * 动态规划法之状态转移方程法
     * 从后往前计算
     * */
    private int[][] mastrix = {{1,3,5,9}, {2,1,3,4}, {5,2,6,7}, {6,8,4,3}};
    private int n = 4;

    private int[][] mem = new int[4][4];

    private int minDist3 (int i, int j) {
        if (i==0 && j==0) {
            return mastrix[0][0];
        }

        // 表示ij下标处已经计算过，无需再重复计算
        if (mem[i][j] > 0) {
            return mem[i][j];
        }

        int minLeft = Integer.MAX_VALUE;
        if (i-1>0) {
            minLeft=minDist3(i-1, j);
        }

        int minTop = Integer.MAX_VALUE;
        if (j-1>0) {
            minTop=minDist3(i,j-1);
        }

        int currentDis = mastrix[i][j] + Math.min(minLeft, minTop);
        mem[i][j] = currentDis;
        return currentDis;
    }

}
