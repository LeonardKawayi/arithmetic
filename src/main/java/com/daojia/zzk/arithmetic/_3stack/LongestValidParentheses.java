package com.daojia.zzk.arithmetic._3stack;

import java.util.Stack;

/**
 * @author zhangzk
 * 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 */
public class LongestValidParentheses {

    int longestValidParentheses (String s) {
        if (s == "" || s == null) {
            return 0;
        }
        int max = 0, start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - start + 1);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }

        return max;
    }
}
