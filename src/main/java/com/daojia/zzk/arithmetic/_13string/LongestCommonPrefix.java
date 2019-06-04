package com.daojia.zzk.arithmetic._13string;

/**
 * @author zhangzk
 * 最长公共前缀
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();

        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return sb.toString();
                }

                if (strs[j].charAt(i) == c && j == strs.length - 1) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
