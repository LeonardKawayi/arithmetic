package com.daojia.zzk.arithmetic._1array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangzk
 * 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {


    /**
     * 思路1： 使用hashmap计数
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * 执行结果：
     * 执行用时 : 42 ms, 在Majority Element的Java提交中击败了16.31% 的用户
     * 内存消耗 : 49.6 MB, 在Majority Element的Java提交中击败了36.38% 的用户
     * */
    public int majorityElement (int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int value = map.get(nums[i]);
                if (value >= nums.length / 2) {
                    return nums[i];
                } else {
                    map.put(nums[i], value + 1);
                }
            }
        }

        return -1;
    }

    /**
     * 思路2:
     * 众数 > nums /2, 那么排序后中间位置一定是要找的数，如果一定存在的话
     * 执行用时 : 4 ms
     * 内存消耗 : 49.4 MB
     * */
    public int majorityElement2 (int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     * 在任何数组中，出现次数大于该数组长度一半的值只能有一个。
     * 摩尔投票法的基本思想很简单，在每一轮投票过程中，从数组中找出一对不同的元素，将其从数组中删除。
     * 这样不断的删除直到无法再进行投票，如果数组为空，则没有任何元素出现的次数超过该数组长度的一半。如果只存在一种元素，那么这个元素则可能为目标元素。
     * 执行用时 : 2 ms, 在Majority Element的Java提交中击败了99.93% 的用户
     * 内存消耗 : 41 MB, 在Majority Element的Java提交中击败了85.16% 的用户
     * */
    public static int majorityElement3 (int[] nums) {
        // 预期的众数值
        int majority = -1;

        // 与众数相同值时+1，不同时-1。如果最终数值大于0，那么majority就是数量超过一半的众。如果count最终<=0，那么没有超过一半的众数
        int count = 0;
        for (int num : nums) {
            // count等于0时表明已经遍历过的数组中没有超过一半的众数，下一个值标记为众数候选
            if (count == 0) {
                majority = num;
                count++;
            } else {
                // count>0时，有众数候选，此次遍历值与众数值相同，则count+1
                if (majority == num) {
                    count++;
                } else {
                    // 此次遍历值与众数值不同，则count-1
                    count--;
                }
            }
        }

        return majority;
    }

    public static void main(String[] args){
        int[] nums = new int[] {3,2,3,4,5,6,3,2,3,3};
        int i = majorityElement3(nums);
        System.out.println(i);
    }

}
