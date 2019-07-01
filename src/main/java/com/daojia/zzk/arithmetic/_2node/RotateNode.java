package com.daojia.zzk.arithmetic._2node;

/**
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class RotateNode {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0 ) return head;

        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p != null && p.next != null) {
                p = p.next;
            }
        }
        ListNode slow = head;
        while (p.next != null) {
            p = p.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode q = next;
        while (next.next != null) {
            next = next.next;
        }
        next.next = head;
        return q;
    }
}
