package com.daojia.zzk.arithmetic._2node;

import java.util.Stack;

/**
 * @author zhangzk
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode index1 = l1, index2 = l2;
        int length1 = 0;
        int length2 = 0;
        int carry = 0;

        while (index1 != null || index2 != null) {
            if (index1 != null) {
                stack1.push(index1);
                index1 = index1.next;
                length1++;
            }
            if (index2 != null) {
                stack2.push(index2);
                index2 = index2.next;
                length2++;
            }
        }

        if (length1 >= length2) {
            while (!stack1.isEmpty()) {
                ListNode tmp = stack1.pop();
                int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;
                int sum = tmp.val + num2 + carry;
                int result = sum % 10;
                tmp.val = result;
                carry = sum / 10;
            }
            if (carry == 1) {
                ListNode listNode = new ListNode(1);
                listNode.next = l1;
                return listNode;
            } else {
                return l1;
            }
        } else {
            while (!stack2.isEmpty()) {
                ListNode pop = stack2.pop();
                int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
                int sum = num1 + pop.val + carry;
                int result = sum % 10;
                pop.val = result;
                carry = sum /10;
            }
            if (carry == 1) {
                ListNode listNode = new ListNode(1);
                listNode.next = l2;
                return listNode;
            } else {
                return l2;
            }
        }
    }
}
