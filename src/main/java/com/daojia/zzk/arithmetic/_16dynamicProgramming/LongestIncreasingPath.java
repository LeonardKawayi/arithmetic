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

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;

        // 再利用一个 visited[][] 数组记录当前位置是否遍历过，如果已经处理过该点，那么直接返回该点对应的路径长度即可。
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        // 用一个数组 len[][] 记录任意点的递增路径长度
        int[][] len = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, find(matrix, visited, len, i, j));
            }
        }

        return max;
    }

    private int[] row = {-1,1,0,0};
    private int[] col = {0,0,-1,1};

    private int find (int[][] matrix, boolean[][] visited, int[][] len, int x, int y) {
        if (visited[x][y]) return len[x][y];

        len[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int curX = x + row[i];
            int curY = y + col[i];
            if (curX > 0 && curX < matrix.length && curY > 0 && curY < matrix[0].length && matrix[curX][curY] < matrix[x][y]) {
                len[x][y] = Math.max(len[x][y], find(matrix, visited, len, curX, curY));
            }
        }
        visited[x][y] = true;
        return len[x][y];
    }
}
