package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeros {

    public static void moveZeros (int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{0,1,4,0,3,0};
        moveZeros(array);

        for (int i : array) {
            System.out.println(i);
        }
    }
}
