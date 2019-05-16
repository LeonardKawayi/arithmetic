package com.daojia.zzk.arithmetic._13string;

/**
 * @author zhangzk
 * 反转字符串
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right --;
        }
    }

    private void swap (char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
