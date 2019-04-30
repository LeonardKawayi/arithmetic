package com.daojia.zzk.arithmetic._2node;

/**
 * @author zhangzk
 * 合并两个有序链表
 */
public class MergerSortedNode {


    /**
     * 分治递归思想
     * 执行用时 : 6 ms, 在Merge k Sorted Lists的Java提交中击败了95.29% 的用户
     * 内存消耗 : 40.5 MB, 在Merge k Sorted Lists的Java提交中击败了83.47% 的用户
     * */
    public static ListNode mergeKLists (ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        } else if (lists.length == 2) {
            return mergerTwoList(lists[0], lists[1]);
        }

        int mid = lists.length / 2;

        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = 0; i < lists.length - mid; i++) {
            l2[i] = lists[mid + i];
        }

        return mergerTwoList(mergeKLists(l1), mergeKLists(l2));

    }


    /**
     * 合并两个ListNode
     * */
    public static ListNode mergerTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) return l1;

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergerTwoList(l1.next, l2);
        } else {
            head = l2;
            head.next = mergerTwoList(l1, l2.next);
        }

        return head;
    }
}
