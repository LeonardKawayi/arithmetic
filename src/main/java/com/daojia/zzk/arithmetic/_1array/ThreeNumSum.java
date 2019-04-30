package com.daojia.zzk.arithmetic._1array;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangzk
 * 三数之和 力扣  https://leetcode-cn.com/problems/3sum/
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 */
public class ThreeNumSum {

    public static void main(String[] args) throws Exception{
        int[] nums = new int[] {-3,-2,5,0,6,2,4,-6,3};

        long startTime = Instant.now().getEpochSecond();
        List<List<Integer>> lists = threeSum(nums, 0);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

        long endTime = Instant.now().getEpochSecond();
        System.out.println(endTime - startTime);
    }
    
    
    public static List<List<Integer>> threeSum(int[] nums, int result) {
        if (nums == null) {
            return null;
        }

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        // 先排序
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        // i 从0开始跑，j从i+1开始跑， k从最后一个开始往前跑
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                // 等于result的结果
                if (nums[i] + nums[j] + nums[k] == result) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    set.add(list);

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k-1]) {
                        k--;
                    }
                    j++;
                    k--;
                    // 小于result的结果
                } else if (nums[i] + nums[j] + nums[k] < result) {
                    j++;
                } else {
                    // 大于result的结果
                    k--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
