package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 数学表达式如下:
 *  如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 *  使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *  说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 */
public class IncreasingTriplet {

    /**
     * 贪心算法
     * */
    public static boolean increasingTriplet (int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i < first) {
                first = i;
            } else if (i > first && i < second) {
                second = i;
            } else if (i > second) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args){
        int[] array = new int[]{5,4,3,2,1};
        System.out.println(increasingTriplet(array));
    }
}

