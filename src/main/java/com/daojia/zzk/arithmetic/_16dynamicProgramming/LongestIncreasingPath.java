package com.daojia.zzk.arithmetic._16dynamicProgramming;

/**
 * @author zhangzk
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * 输入: nums =
    [
    [9,9,4],
    [6,6,8],
    [2,1,1]
    ]
    输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 */
public class LongestIncreasingPath {

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] len = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, find(matrix, visited, len, i, j));
            }
        }

        return max;
    }

    private static int[] row = {-1,1,0,0};
    private static int[] col = {0,0,-1,1};

    private static int find (int[][] matrix, boolean[][] visited, int[][] len, int x, int y) {
        if (visited[x][y]) return len[x][y];

        len[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int curX = x + row[i];
            int curY = y + col[i];
            if (curX >=0 && curX<matrix.length && curY>=0 && curY < matrix[0].length && matrix[curX][curY] < matrix[x][y]) {
                len[x][y] = Math.max(len[x][y], find(matrix, visited, len, curX, curX) + 1);
            }
        }

        visited[x][y] = true;
        return len[x][y];
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        int i = longestIncreasingPath(matrix);
        System.out.println(i);
    }
}
