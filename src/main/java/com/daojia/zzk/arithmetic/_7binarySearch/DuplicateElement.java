package com.daojia.zzk.arithmetic._7binarySearch;

/**
 * @author zhangzk
 * 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 输入: [1,3,4,2,2]
 * 输出: 2
 */
public class DuplicateElement {

    /**
     快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     即按照寻找链表环入口的思路来做
     **/
    public static int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    /**
     * 二分查找思想
     * */
    public static int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return -1;
        if (nums.length == 2) return nums[0] == nums[1] ? nums[0] : -1;
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public static void main(String[] args){
        int[] array = new int[]{3,1,3,4,2};
        int duplicate = findDuplicate(array);
        System.out.println(duplicate);
        int duplicate2 = findDuplicate2(array);
        System.out.println(duplicate2);
    }
}
