package com.daojia.zzk.arithmetic._10tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangzk
 * 二叉树迭代器
 *
 */
public class BSTIterator {
    private Queue<BinarySearchTreeNode> queue = new LinkedList<>();

    public BSTIterator(BinarySearchTreeNode root) {
        add(root);
    }

    /** @return the next smallest number */
    public int next() {
        BinarySearchTreeNode poll = queue.poll();
        if (poll != null) {
            return poll.value;
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.peek() == null ? false : true;
    }

    private void add (BinarySearchTreeNode root) {
        if (root == null) return;

        if (root.left != null) add(root.left);
        queue.add(root);
        if (root.right != null) add(root.right);
    }

}
