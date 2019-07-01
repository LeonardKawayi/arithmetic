package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 下一个排列
 * 1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        boolean haveSwap = false;
        int index = nums.length - 1;
        while (index > 0) {
            for (int i = index-1; i >=0; i--) {
                if (nums[i] < nums[index]) {
                    swap(nums, i, index);
                    haveSwap = true;
                    break;
                }
                if (i == 0) {
                    index--;
                }
            }
            if (haveSwap) break;
        }

        if (!haveSwap) {
            reverseArray(nums);
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private static void reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{1,3,2};
        nextPermutation(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
