package com.daojia.zzk.arithmetic._1array;

import java.util.Arrays;

/**
 * 实现两个有序数组合并为一个有序数组
 */
public class MergerSortedArray {
    public static void main(String[] args){
        int[] arrayA = new int[]{1,3,5,7,9};
        int[] arrayB = new int[]{2,4,6,8,10};

        // 用以标记两个数组遍历到的下标
        int a = 0;
        int b = 0;

        int[] result = new int[arrayA.length + arrayB.length];

        for (int i = 0; i < result.length; i++) {
            if (a < arrayA.length && b < arrayB.length) {
                if (arrayA[a] > arrayB[b]) {
                    result[i] = arrayB[b];
                    b++;
                } else {
                    result[i] = arrayA[a];
                    a++;
                }
            } else if (a < arrayA.length) {
                result[i] = arrayA[a];
                a++;
            } else {
                result[i] = arrayB[b];
                b++;
            }
        }

        System.out.println("排序后： result: " + Arrays.toString(result));
    }
}
