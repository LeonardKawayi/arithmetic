package com.daojia.zzk.arithmetic._1array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzk
 *  给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *  输入:
    [
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
    ]
    输出: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int y = matrix.length;
        int x = matrix[0].length;

        int up = 0, down = y-1, left = 0, right = x-1;
        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            if (up > down) break;
            for (int i = up; i <=down ; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;

            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            if (down<up) break;
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return result;
    }
}
