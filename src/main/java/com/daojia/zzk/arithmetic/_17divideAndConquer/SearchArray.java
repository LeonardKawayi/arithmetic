package com.daojia.zzk.arithmetic._17divideAndConquer;

/**
 * @author zhangzk
 * 搜索二维矩阵
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class SearchArray {

    /**
     * 分治法。
     *   左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标：
     *       若左下角元素等于目标，则找到
     *       若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
     *       若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标
     *   若最后矩阵减小为空，则说明不存在
     * */
    public boolean searchArray (int[][] matrix, int target) {
        if (matrix.length==0)
            return false;
        if (matrix[0].length==0)
            return false;

        int i = matrix.length-1;
        int j = 0;

        while (i>=0 && j< matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }

        return false;
    }
}
