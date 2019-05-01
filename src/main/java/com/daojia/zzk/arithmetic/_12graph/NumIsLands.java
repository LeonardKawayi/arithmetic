package com.daojia.zzk.arithmetic._12graph;

/**
 * @author zhangzk
 * 岛屿的个数
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * 输入:
 *  11000
 *  11000
 *  00100
 *  00011
 * 输出: 3
 */
public class NumIsLands {

    static char[][] src = null;
    public static int numIslands(char[][] grid) {
        src = grid;

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (src[i][j] == '1') {
                    result ++;  // 岛屿数量+1
                    loop(i, j); // 使用深度优先搜索将这个岛屿附近的1都变为0
                }
            }
        }

        return result;
    }

    private static void loop (int i , int j) {
        if (i > src.length || i < 0 || j > src[0].length || j < 0) {
            return;
        }

        if (src[i][j] == '1') {
            src[i][j] = '0';
            loop(i-1, j);
            loop(i, j-1);
            loop(i+1, j);
            loop(i, j+1);
        }
    }

    public static void main(String[] args){
        char[][] guid = new char[4][5];
        guid[0][0] = '1';
        guid[0][1] = '1';
        guid[0][2] = '1';
        guid[0][3] = '1';
        guid[0][4] = '0';
        guid[1][0] = '1';
        guid[1][1] = '1';
        guid[1][2] = '0';
        guid[1][3] = '1';
        guid[1][4] = '0';
        guid[2][0] = '1';
        guid[2][1] = '1';
        guid[2][2] = '0';
        guid[2][3] = '0';
        guid[2][4] = '0';
        guid[3][0] = '0';
        guid[3][1] = '0';
        guid[3][2] = '0';
        guid[3][3] = '0';
        guid[3][4] = '0';

        int i = numIslands(guid);
        System.out.println(i);
    }

}
