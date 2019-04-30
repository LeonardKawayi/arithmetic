package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 示例 1:
 *   输入: [1,2,0]
 *   输出: 3
 * 示例 2:
 *   输入: [3,4,-1,1]
 *   输出: 2
 * 示例 3:
 *   输入: [7,8,9,11,12]
 *   输出: 1
 */
public class MinMissedNum {

    public static int minMissedNum (int[] nums) {
        for(int i=0;i<nums.length;++i)
        {
            while(nums[i]>=1&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i])
            {
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for(int i=0;i<nums.length;++i)
            if(nums[i]!=i+1)
                return i+1;
        return nums.length+1;
    }

    /**
     * 基于桶排序原理，时间大于97%空间大于96%
     * */
    public static int minMissedNum2 (int[] nums) {
        int len = nums.length;
        if(len == 0) return 1;
        int max = Integer.MIN_VALUE;
        //找出数组中最大的数
        for(int i = 0; i < nums.length; i++){
            max = max > nums[i]? max : nums[i];
        }
        //如果最大的数是负数 返回1
        if(max <= 0) return 1;
        if(max > len) max = len;
        //基于桶排序方法，构建index和值相同的数组
        int[] bucket = new int[max + 1];
        for(int i = 0; i < len; i++){
            if(nums[i] <= 0 || nums[i] > len) continue;
            bucket[nums[i]]++;
        }
        //排除数组中全为大于len的值和数组中没有1的情况
        if(bucket.length == 0 || bucket[1] == 0) return 1;
        int i = 1;
        //当第一个index 不等于其值的下一个index为最终结果
        for(; i < bucket.length; i++){
            if(bucket[i] == 0) break;
        }
        return i ;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,0};
        int i = minMissedNum(nums);
        System.out.println(i);
    }
}
