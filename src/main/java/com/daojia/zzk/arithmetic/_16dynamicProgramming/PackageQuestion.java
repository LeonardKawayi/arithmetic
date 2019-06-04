package com.daojia.zzk.arithmetic._16dynamicProgramming;

import java.util.Arrays;

/**
 * @author zhangzk
 * 一排盒子，每个盒子上标了能走的最大步数，从第一个盒子开始，判断能否走到最后的盒子
 */
public class PackageQuestion {

    public static boolean findPath (int[] array) {
        boolean[] dp = new boolean[array.length - 1];
        dp[0] = true;

        Arrays.fill(dp, 1, array.length - 1, false);

        for (int i = 0; i < array.length - 1; i++) {
            if (dp[i] && (array[i] + i < array.length - 1)) {
                dp[array[i] + i] = true;
            }
        }

        return  dp[array.length - 1];
    }

    public static void main(String[] args){
        int[] array = new int[]{1,2,3,3,2,3,4};
        boolean path = findPath(array);
        System.out.println(path);
    }
}
