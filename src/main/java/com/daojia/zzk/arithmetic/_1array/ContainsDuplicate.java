package com.daojia.zzk.arithmetic._1array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangzk
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class ContainsDuplicate {

    /**
     * 首先想到用set
     * 如果包含，就是true
     * 然后想到用set的长度与原数组长度对比
     * */
    public boolean containsDuplicate3 (int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate2 (int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        return set.size() != nums.length;
    }

    /**
     * 直接java8比较长度
     * */
    public boolean containsDuplicate (int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
}
