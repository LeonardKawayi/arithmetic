package com.daojia.zzk.arithmetic._3stack;

import java.util.Stack;

/**
 * @author zhangzk
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 执行用时 : 5 ms, 在Valid Parentheses的Java提交中击败了91.62% 的用户
 * 内存消耗 : 34.1 MB, 在Valid Parentheses的Java提交中击败了87.20% 的用户
 */
public class ValidBracket {

    public boolean isValid (String s) {
        if (s == "" || s == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();
                if ((pop == '(' && c == ')') || (pop=='[' && c == ']') || (pop=='{' && c=='}')) {
                    continue;
                }

                return false;

            }
        }

        return stack.isEmpty();
    }
}
