package com.daojia.zzk.arithmetic._1array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzk
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * */
public class MajorityElement2 {

    /**
     * 摩尔投票法
     * */
    public static List<Integer> majorityElement (int[] nums ) {
        int num1 = 0, num2 = 1;
        int count1 = 0, count2 = 0;
        for(int num: nums) {
            if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (num1 == num) {
                count1 ++;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else if (num2 == num) {
                count2 ++;
            } else {
                count1 --;
                count2 --;
                if (count1 == 0 && count2 > 0) {
                    num1 = num2;
                    count1 = count2;
                    num2 = 0;
                    count2 = 0;
                }
            }
        }
        if (count1 > 0) {
            count1 = 0;
            for(int num: nums) if (num1 == num) count1 ++;
        }
        if (count2 > 0) {
            count2 = 0;
            for(int num: nums) if (num2 == num) count2 ++;
        }
        List<Integer> results = new ArrayList<>();
        if (count1*3>nums.length) results.add(num1);
        if (count2*3>nums.length) results.add(num2);
        return results;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,1,4,1,1,1,2,2,5,2,2};

        List<Integer> integers = majorityElement(nums);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
