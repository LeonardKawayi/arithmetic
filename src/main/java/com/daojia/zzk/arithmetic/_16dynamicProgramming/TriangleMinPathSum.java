package com.daojia.zzk.arithmetic._16dynamicProgramming;

import java.util.List;

/**
 * @author zhangzk
 * 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
        [
        [2],
        [3,4],
        [6,5,7],
        [4,1,8,3]
        ]
 *   自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class TriangleMinPathSum {

    /**
     * 借助一个二维数组
     * */
    int triangleMinPathSum (List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        // 加1可以不用初始化最后一层
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];

        for (int i = triangle.size()-1; i>=0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0 ; j< curTr.size(); j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 一位数组
     * */
    int triangleMinPathSum2 (List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        // 只需要记录每一层的最小值即可
        int[] dp = new int[triangle.size()+1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
                dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
            }
        }

        return dp[0];
    }

    int triangleMinPathSum3 (List<List<Integer>> triangle) {
        if(triangle.size()==0) return 0;
        for(int i = triangle.size()-2; i >= 0; i--){
            List<Integer> pre = triangle.get(i+1);
            List<Integer> cur = triangle.get(i);
            for(int j = 0; j < cur.size(); j++){
                cur.set(j,Math.min(pre.get(j),pre.get(j+1))+cur.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
