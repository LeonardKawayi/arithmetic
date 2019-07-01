package com.daojia.zzk.arithmetic._1array;

/**
 * @author zhangzk
 * 输入: 3
   输出:
    [
    [ 1, 2, 3 ],
    [ 8, 9, 4 ],
    [ 7, 6, 5 ]
    ]
 */
public class SpiralOrder2 {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int up = 0, down = n-1, left = 0, right = n-1;

        int count = 0;
        while (count <= n*n) {
            for (int i = left; i <= right; i++) {
                result[up][i] = ++count;
            }
            up++;
            if (up > down) break;
            for (int i = up; i <=down ; i++) {
                result[i][right] = ++count;
            }
            right--;
            if (right < left) break;
            for (int i = right; i >=left ; i--) {
                result[down][i] = ++count;
            }
            down--;
            if (down<up) break;
            for (int i = down; i >=up ; i--) {
                result[i][left] = ++count;
            }
            left++;
            if (left > right) break;
        }
        return result;
    }

    public static void main(String[] args){
        int[][] ints = generateMatrix(2);
    }
}
