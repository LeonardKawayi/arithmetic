package com.daojia.zzk.arithmetic.dynamicProgramming;

/**
 * @author zhangzk
 * 字符串纠错：编辑距离
 * 莱文斯坦距离：越大表示两个字符串差异越大
 * 最长公共子串：两个字符串相似程度
 */
public class EditDistance {

    /**
     * 回溯算法实现莱文斯坦距离
     * */
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();

    private int n = 6;
    private int m = 6;

    private int minDist = Integer.MAX_VALUE;
    public void lwst (int i, int j, int edit) {
        if (i==n || j==m) {
            if (i < n) edit += (n-i);
            if (j < m) edit += (m-j);
            if (edit < minDist) {
                minDist = edit;
            }
            return;
        }

        // 两个字符串匹配
        if (a[i] == b[j]) {
            lwst(i+1, j+1, edit);
        } else {
          // 两个字符串不匹配
          // 删除a[i]或者b[j]前添加一个字符
          lwst(i+1, j, edit+1);
          // 删除b[j]或者a[i]前添加一个字符
          lwst(i, j+1, edit+1);
          // 将a[i]和b[j]替换为相同字符
          lwst(i+1, j+1, edit+1);
        }
    }

    /**
     * 动态规划法实现莱文斯特
     * */
    public int lwstDP (char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];

        // 初始化第 0 行:a[0..0] 与 b[0..j] 的编辑距离
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                minDist[j][0] = j;
            } else {
                if (j == 0) {
                    minDist[j][0] = 1;
                } else {
                    minDist[j][0] = minDist[j-1][0] + 1;
                }
            }
        }

        // 初始化第 0 列:a[0..i] 与 b[0..0] 的编辑距离
        for (int i = 0; i < n; i++) {
            if (b[0] == a[i]) {
                minDist[0][i] = i;
            } else {
                if (i == 0) {
                    minDist[0][i] = 1;
                } else {
                    minDist[0][i] = minDist[0][i-1] +1;
                }
            }
        }

        // 按行填表
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i]==b[j]) {
                    minDist[i][j] = min(minDist[i-1][j]+1, minDist[i][j-1] + 1, minDist[i-1][j-1]);
                } else {
                    minDist[i][j] = min(minDist[i-1][j]+1, minDist[i][j-1] + 1, minDist[i-1][j-1]+1);
                }
            }
        }

        return minDist[n-1][m-1];
    }

    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }


    /**
     * 最长公共字串求解
     * 动态规划实现
     * */
    public int maxSubString (char[] a, int n, char[] b, int m) {
        int[][] maxLength = new int[n][m];

        // 初始化第一行
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                maxLength[0][j] = 1;
            } else {
                if (j == 0)  maxLength[0][j] = 0;
                else maxLength[0][j] = maxLength[0][j-1];
            }
        }

        // 初始化第一列
        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                maxLength[i][0] = 1;
            } else {
                if (i == 0) maxLength[i][0] = 0;
                else maxLength[i][0] = maxLength[i-1][0];
            }
        }

        // 按行填表
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    maxLength[i][j] = max(maxLength[i-1][j], maxLength[i][j-1], maxLength[i-1][j-1] + 1);
                } else {
                    maxLength[i][j] = max(maxLength[i-1][j], maxLength[i][j-1], maxLength[i-1][j-1]);
                }
            }
        }

        return maxLength[n-1][m-1];
    }

    private int max (int a, int b, int c) {
        int tmp = Integer.MIN_VALUE;
        if (tmp > a) tmp = a;
        if (tmp > b) tmp = b;
        if (tmp > c) tmp = c;
        return tmp;
    }

}
