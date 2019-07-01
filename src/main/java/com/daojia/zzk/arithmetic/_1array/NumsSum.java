package com.daojia.zzk.arithmetic._1array;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auhtor zhangzk
 *
 * 数组中多个数之和等于固定值
 */
public class NumsSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null)
            return result;
        Arrays.parallelSort(candidates);
        return combinationSum(candidates, target, 0);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] < target) {
                for (List<Integer> list : combinationSum(candidates, target - candidates[i], i)) {
                    list.add(0, candidates[i]);
                    result.add(list);
                }
            } else if ((target - candidates[i]) == 0) {
                List<Integer> res = new ArrayList<>();
                res.add(candidates[i]);
                result.add(res);
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {3000000, 400000, 150000, 735942, 150000, 1000, 591923, 1800000, 500000, 4172481, 1466900, 3863100, 365650, 45114, 210120, 21773094};
        int target = 33999300;
        List<List<Integer>> lists = combinationSum(nums, target);
        System.out.println(lists.size());
    }
}
