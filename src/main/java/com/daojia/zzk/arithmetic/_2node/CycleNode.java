package com.daojia.zzk.arithmetic._2node;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangzk
 * 链表中环的检测
 */
public class CycleNode {

    /**
     * 思路： leetcode给出的解法：我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）
     * */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }

        return false;
    }

    /**
     * 快慢指针
     * 两个指针，一个走一步，一个走两步
     * */
    public boolean hasCycle2 (ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;

            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }

}