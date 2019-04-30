package com.daojia.zzk.arithmetic.prime;

import java.util.ArrayList;

/**
 * @author zhangzk
 * 求解微信号码
 */
public class PrimeNumber {

    static ArrayList<Integer> list = new ArrayList<>();

    /**
     * 初始化素数表
     * @return
     */
    public static ArrayList<Integer> initArrayList() {
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        return list;
    }

    /**
     * 判断n是不是素数
     * @param n
     * @return true或false
     */
    public static boolean isPrime(int n) {
        boolean flag = true;
        int temp = (int) Math.sqrt(n);
        for (int i = 0; i < list.size(); i++) {
            if (i > temp)
                break;
            if (n % list.get(i) == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        list = initArrayList();
        for (int i = 11; i < Math.sqrt(707829217); i += 2) {
            if(707829217L % i == 0){
                System.out.println(i +"     " + 707829217L / i);
                if(isPrime(i)){
                    list.add(i);
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long usedTime = endTime - startTime;
        System.out.println(usedTime);
    }
}

