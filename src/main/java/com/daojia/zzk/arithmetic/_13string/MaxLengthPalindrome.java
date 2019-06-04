package com.daojia.zzk.arithmetic._13string;

/**
 * @author zhangzk
 * 最长回文字串
 */
public class MaxLengthPalindrome {

    /**
     * 暴力匹配法
     * */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;

        String res = s.substring(0,1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                String reverse = new StringBuffer(substring).reverse().toString();
                if (substring.equals(reverse) && substring.length() > res.length()) {
                    res = substring;
                }
            }
        }
        return res;
    }

    /**
     * 动态规划法
     * */
    public String longestPalindromeDp(String s) {
        if (s == null || s.isEmpty()) return s;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (int i = n-2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i+1; j < n; j++) {
                //小于3是因为aba一定是回文
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-1 < 3 || dp[i+1][j-1]);
                if (dp[i][j] && right-left < j-i) {
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left,right+1);
    }
}
