package com.daojia.zzk.arithmetic._2node;

/**
 * @author zhangzk
 * 奇偶链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class OddEvenListNode {

    public ListNode oddEvenList(ListNode head) {
        // 如果链表长度为0/1/2则直接返回链表
        if(head  == null || head.next == null || head.next.next == null)
            return head;

        // 奇链表头
        ListNode odd = head;
        // 奇链表尾
        ListNode oddP = head;
        // 偶连头
        ListNode even = head.next;
        // 偶链表尾
        ListNode evenP = head.next;

        while (oddP.next != null && evenP.next != null) {
            // 交替把节点连接到奇数或偶数后面
            oddP.next = evenP.next;
            oddP = oddP.next;
            evenP.next = oddP.next;
            evenP = evenP.next;
        }

        // 最后将偶数连到奇数最后
        oddP.next = even;
        return odd;
    }
}
