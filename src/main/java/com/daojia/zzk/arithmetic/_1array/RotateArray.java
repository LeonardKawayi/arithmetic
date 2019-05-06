package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 *  向右旋转 1 步: [7,1,2,3,4,5,6]
 *  向右旋转 2 步: [6,7,1,2,3,4,5]
 *  向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    /**
     * 双重循环
     * 时间复杂度O（kn）
     * 空间复杂度O（1）
     * */
    public static void retate1 (int[] array, int k) {
        int n = array.length;
        k %= n;

        for (int i = 0; i < k; i++) {
            int tmp = array[n-1];

            for (int j = n-1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = tmp;
        }
    }

    /**
     * 翻转
     * 1、反转前半部分
     * 2、反转后半部分
     * 3、反转全部
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     * */
    public static void retate2 (int[] array, int k) {
        int n = array.length;
        k%=n;

        reverse(array, 0, n-k-1);
        reverse(array, n-k, n-1);
        reverse(array, 0, n-1);
    }

    private static void reverse (int[] array, int start, int end) {
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }



    public static void main(String[] args){
        int[] array = new int[]{5,6,7,1,2,3,4};
//        retate1(array, 4);
        retate2(array, 4);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
