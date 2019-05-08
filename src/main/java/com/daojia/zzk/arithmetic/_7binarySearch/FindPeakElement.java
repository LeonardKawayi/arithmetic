package com.daojia.zzk.arithmetic._7binarySearch;

/**
 * @author zhangzk
 * 寻找峰值峰
 * 值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid=left + (right-left) >> 1;
            if(mid!=0&&nums[mid-1]>nums[mid]){
                right=mid-1;
            }else if(mid!=nums.length-1&&nums[mid+1]>nums[mid]){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
