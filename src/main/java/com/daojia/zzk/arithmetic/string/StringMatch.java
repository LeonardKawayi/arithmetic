package com.daojia.zzk.arithmetic.string;

/**
 * 字符串匹配算法
 */
public class StringMatch {

    /**
     * BF算法
     * @param sStr 主串
     * @param dStr 模式串（字串）
     * 时间复杂度：O（n*m）
     * */
    public int bruteForce (String sStr, String dStr) {
        int sLength = sStr.length();
        int dLength = dStr.length();
        int sIndex = 0;
        int dIndex = 0;

        while (sIndex < sLength && dIndex < dLength) {
            //当前字符匹配
            if (sStr.charAt(sIndex) == dStr.charAt(dIndex)) {
                // 父串和子串同时后移一个字符
                sIndex++;
                dIndex++;
            } else {
                //不匹配则sIndex回溯，dIndex被置为0
                sIndex = sIndex - (dIndex - 1);
                dIndex = 0;
            }
        }
        if (dIndex == dLength) {
            return sIndex - dLength;
        }

        return -1;
    }

    private static final int SIZE = 256;

    /**
     * @param b 模式串
     * @param m 模式串长度
     * @params bc 散列表
     * */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // 初始化 bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int)b[i]; // 计算 b[i] 的 ASCII 值
            bc[ascii] = i;
        }
    }


    /**
     * BM算法：坏字符规则和好后缀规则
     *
     * */
    public int bm(char[] a, int n, char[] b, int m) {
        // 记录模式串中每个字符最后出现的位置
        int[] bc = new int[SIZE];
        // 构建坏字符哈希表
        generateBC(b, m, bc);
        // i 表示主串与模式串对齐的第一个字符
        int i = 0;
        while (i <= n - m) {
            int j;
            // 模式串从后往前匹配
            for (j = m - 1; j >= 0; --j) {
                // 坏字符对应模式串中的下标是 j
                if (a[i+j] != b[j]) break;
            }
            if (j < 0) {
                // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                return i;
            }
            // 这里等同于将模式串往后滑动 j-bc[(int)a[i+j]] 位
            i = i + (j - bc[(int)a[i+j]]);
        }
        return -1;
    }

    // b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) { // 初始化
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m-1-k]) { // 与 b[0, m-1] 求公共后缀子串
                --j;
                ++k;
                suffix[k] = j+1; //j+1 表示公共后缀子串在 b[0, i] 中的起始下标
            }
            if (j == -1) prefix[k] = true; // 如果公共后缀子串也是模式串的前缀子串
        }
    }


    // a,b 表示主串和模式串；n，m 表示主串和模式串的长度。
    public int bm2(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc); // 构建坏字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0; // j 表示主串与模式串匹配的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i+j] != b[j]) break; // 坏字符对应模式串中的下标是 j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            int x = j - bc[(int)a[i+j]];
            int y = 0;
            if (j < m-1) { // 如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    // j 表示坏字符对应的模式串中的字符下标 ; m 表示模式串长度
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        if (suffix[k] != -1) return j - suffix[k] +1;
        for (int r = j+2; r <= m-1; ++r) {
            if (prefix[m-r] == true) {
                return r;
            }
        }
        return m;
    }




    /**
     * KMP匹配算法
     * @param sStr 父串
     * @param dStr 子串
     * @return 子串在父串中下标index[int]
     * */
    public static int kMPMatch (String sStr, String dStr) {
        int sLength = sStr.length();
        int dLength = dStr.length();
        int sIndex = 0, dIndex = 0;
        int[] next = getNextArray(dStr);

        while (sIndex < sLength && dIndex < dLength) {
            //当前字符匹配
            if (dIndex==-1||sStr.charAt(sIndex) == dStr.charAt(dIndex)) {
                //父串和子串同时后移一个字符
                sIndex++;
                dIndex++;
            } else {//不匹配 sIndex不变dIndex取next[j]
                dIndex = next[dIndex];
            }
        }
        if (dIndex == dLength) {
            return sIndex - dLength;
        }
        return -1;
    }

    /**
     * 获取next数组
     * @param destStr 目的字符串
     * @return next数组
     */
    public static int[] getNextArray(String destStr) {
        int[] nextArr = new int[destStr.length()];
        nextArr[0] = -1;
        int k = -1, j = 0;
        while (j < destStr.length() - 1) {
            if (k == -1 || (destStr.charAt(j) == destStr.charAt(k))) {
                ++k;
                ++j;
                nextArr[j] = k;
            } else {
                k = nextArr[k];
            }
        }
        return nextArr;
    }

}
