package com.daojia.zzk.arithmetic._2node;

/**
 * @author zhangzk
 *
 * 单链表反转
 */
public class ReverseSingleNode1 {

    /**
     * 方法1  迭代法
     * 思路： 先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点
     * */
    public static Node reverse1 (Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node prev = null;
        Node now = head;
        while (now != null ) {
            Node next = now.getNext();
            now.setNext(prev);
            prev = now;
            now = next;
        }

        return prev;
    }

    /**
     * 方法2: 递归方法1。
     * 思路： 先找到最后一个节点，然后从最后一个开始反转,然后当前节点反转时其后面的节点已经进行反转了，不需要管。最后返回原来的最后一个节点
     * */
    public static Node reverse2 (Node node, Node prev) {
        if (node.getNext() == null) {
            node.setNext(prev);
            return node;
        } else {
            Node no = reverse2(node.getNext(), node);
            node.setNext(prev);
            return no;
        }
    }

    /**
     * 方法3: 递归方法2。
     * 思路： 先找到最后一个节点，然后从最后一个节点之前的那个节点的方法体中开始将下一个指向当前一个,然后当前节点反转时其后面的节点已经进行反转了，不需要管。最后返回原来的最后一个节点。
     * */
    public static Node reverse3 (Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            // 若为空链或者当前结点在尾结点，则直接还回
            return head;
        }
        // 先反转后续节点head.getNext()
        Node reHead = reverse3(head.getNext());
        // 将当前结点的指针域指向前一结点
        head.getNext().setNext(head);
        // 前一结点的指针域令为null;
        head.setNext(null);
        // 反转后新链表的头结点
        return reHead;
    }

    /**
     * 方法3: 递归方法3。
     * 思路： 先找到最后一个节点，然后从最后一个节点之前的那个节点的方法体中开始将下一个指向当前一个,然后当前节点反转时其后面的节点已经进行反转了，不需要管。最后返回原来的最后一个节点。
     * */
    public static Node reverse4 (Node node) {
        if (node.getNext() == null) {
            return node;
        }

        Node next = node.getNext();
        node.setNext(null);

        Node reverse3 = reverse4(next);
        next.setNext(node);
        return  reverse3;
    }
    
    public static void main(String[] args){
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println(head);

//        Node reverse1 = reverse1(head);
//        System.out.println(reverse1);

//        Node reverse3 = reverse3(head);
//        System.out.println(reverse3);

        Node reverse4 = reverse4(head);
        System.out.println(reverse4);
    }

}
