package com.daojia.zzk.arithmetic._1array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangzk
 * 两个数组的交集
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 */
public class IntersectArray {

    /**
     * 使用集合实现
     * */
    public int[] interSect_1 (int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();

        for (int i : nums1) {
            list1.add(i);
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i : nums2) {
            if (list1.contains(i)) {
                list2.add(i);
                list1.remove(i);
            }
        }

        int[] res = new int[list2.size()];
        int i = 0;
        for (int num : list2) {
            res[i++] = num;
        }
        return res;
    }

    /**
     * 使用集合的实现
     */
    public int[] intersect_2(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2)
                .boxed()
                .filter(num -> {
                    if (list1.contains(num)) {
                        list1.remove(num);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        int[] res = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            res[i] = list2.get(i);
        }
        return res;
    }

    /**
     * 使用映射实现
     */
    public int[] intersect_3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        // 将 nums1 出现的数值及频次放入映射中
        for (int num : nums1) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++count);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            // 获取映射中该数值出现的频次
            Integer count = map.get(num);
            if (count != null && count != 0) {
                list.add(num);
                // 注意每次匹配后，该数值的频次需要减 1（nums1 和 nums2 匹配的数值的频次要相同）
                map.put(num, --count);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 排序预处理
     */
    public int[] intersect_4(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
