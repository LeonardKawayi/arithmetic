package com.daojia.zzk.arithmetic._5recursion;

/**
 * @author zhangzk
 * 递归
 */
public class Recursion {

    /**
     * 斐波那契数列
     * f = f(n-1) + f(n-2)
     * */
    static int f (int n) {
        if (n <= 1) {
            return 1;
        }

        return f(n-1) + f(n-2);
    }

    /**
     * n!
     * */
    static int ff(int n) {
        if (n <=1 ) {
            return 1;
        }

        return f(n-1)*n;
    }

    /**
     * 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 其实就是f(n) = f(n-1) + f(n-2)
     * */
    static int climbStairs (int n) {
        if (n <= 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            int res = 0;
            int i = 1, j = 2;
            int k = 3;
            while (k <= n) {
                res = i + j;
                i = j;
                j = res;
                k++;
            }
            return res;
        }
    }

    public static void main(String[] args){
        int f = f(3);
        System.out.println(f);

        int ff = ff(3);
        System.out.println(ff);

        int i = climbStairs(6);
        System.out.println(i);
    }
}
