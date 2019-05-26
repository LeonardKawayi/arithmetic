package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 把一个数组元素中的奇数放左边，偶数放右边
 */
public class OddEven {
    public static void change(int[] a){
        int i = 0;
        int j = a.length-1;

        while (i < j) {
            while (a[i] % 2 == 1 && i<j) {
                i++;
            }
            while (a[j] % 2 == 0 && i < j) {
                j--;
            }
            swap(a, i, j);
        }
    }

    private static void swap (int[] a, int left, int right) {
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    public static void main(String[] args){
        int[] array = new int[]{2,2,4,3,5,2,3,2};
        change(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
