package com.daojia.zzk.arithmetic._7binarySearch;

/**
 * @author zhangzk
 * x 的平方根
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class Xsqrt {

    public static void main(String[] args){
        int i = mySqrt(15);
        System.out.println(i);
    }

    static int mySqrt (int x) {
        if (x<=1) return x;
        int low = 0;
        int high = x - 1;

        while (low <= high) {
            int mid = low + ((high-low)>>1);

            if (x/mid >= mid) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return high;
    }

    public static int mySqrt2(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) >> 1;
        }
        return (int) res;
    }
}
