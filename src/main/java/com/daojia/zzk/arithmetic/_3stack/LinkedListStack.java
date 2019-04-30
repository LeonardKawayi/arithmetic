package com.daojia.zzk.arithmetic._3stack;

/**
 * @author zhangzk
 * 基于链表实现的栈。
 */
public class LinkedListStack {
    private Node top = null;

    public void push (int value) {
        Node node = new Node(value, null);
        if (top == null) {
            top = node;
            top.next = null;
        } else {
            node.next = top;
            top = node;
        }
    }

    public int pop () {
        if (top == null) throw new IllegalArgumentException();
        int value = top.data;
        top = top.next;
        return value;
    }



    static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData () {
            return data;
        }
    }
}

