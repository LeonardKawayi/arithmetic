package com.daojia.zzk.arithmetic._2node;

/**
 * @author zhangzk
 * 实现求链表的中间节点
 * 快慢指针
 */
public class FindMidNode {

    static ListNode findMidNode (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
