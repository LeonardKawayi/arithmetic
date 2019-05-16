package com.daojia.zzk.arithmetic._13string;

/**
 * @author zhangzk
 * 字符串中的第一个唯一字符
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] feq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            feq[c-'a'] +=1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (feq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
