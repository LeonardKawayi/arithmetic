package com.daojia.zzk.arithmetic._2node;

/**
 * @author zhangzk
 * 回文链表
 * 输入: 1->2->2->1
 * 输出: true
 */
public class PalindromeNode {

    public boolean isPalindrome(ListNode head) {
        // 首先使用快慢指针，找到链表的中间节点
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow就是中间节点,反转后半段链表,与前半段链表按个比较
        slow = reverse(slow.next);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }

            slow=slow.next;
            head = head.next;
        }
        return false;
    }

    private ListNode reverse (ListNode node) {
        ListNode prev = null;
        ListNode now = node;

        while (now !=null) {
            ListNode next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }

        return prev;
    }
}
