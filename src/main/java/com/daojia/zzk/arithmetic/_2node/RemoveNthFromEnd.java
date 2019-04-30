package com.daojia.zzk.arithmetic._2node;

/**
 * @author zhangzk
 * 删除链表中倒数第n个节点
 */
public class RemoveNthFromEnd {

    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;

        // p节点先向后移动n位
        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        // 如果当前p为null，表示链表的长度只有n,则要删除的就是头节点
        if (p == null) {
            head = head.next;
            return head;
        }

        // 如果链表的长度大于n，p移动到末尾，q也移动相同距离，则此时q比p少移动n位
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        // so q.next就是要删除的节点
        q.next = q.next.next;

        return head;
    }
}
