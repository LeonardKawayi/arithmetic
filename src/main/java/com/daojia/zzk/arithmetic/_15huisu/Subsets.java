package com.daojia.zzk.arithmetic._15huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzk
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    说明：解集不能包含重复的子集。
输入: nums = [1,2,3]
输出:
[
[3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return result;

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> subList = new ArrayList<>(result.get(j));
                subList.add(nums[i]);
                result.add(subList);
            }
        }

        return result;
    }

    /**
     *  回溯算法实现
     * */
    List<List<Integer>> listAll=new ArrayList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> list=new ArrayList<>();
        sort(list,nums,0);
        return listAll;
    }
    /** \/
     cur                     cur后面有三个元素，说明长度为2的组合有3个
     0    1   2   3
     \/
     0    1   2   3          cur后面有两个元素，说明长度为3的组合有两个
     \/
     0    1    2   3         cur后面有一个元素，说明长度为4的组合有一个

     *  回溯法，我们可以发现此题的规律，每次递归都会产生一个新的子集，
     *  如果当前下标后面还有元素则继续循环递归，否则直接返回上一层
     *  cur为当前下标
     **/
    public void sort(List<Integer> list,int[] nums,int cur){
        listAll.add(new ArrayList<>(list));

        for(int i=cur;i<nums.length;i++){
            list.add(nums[i]);
            sort(list,nums,i+1);
            list.remove(list.size()-1);
        }

    }
}
