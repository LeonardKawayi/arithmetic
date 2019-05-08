package com.daojia.zzk.arithmetic._10tree;

import java.util.Stack;

/**
 * @author zhangzk
 * 二叉搜索树中第K小的元素
 */
public class KthSmallest {

    private int index = 0;
    private int kthValue = 0;

    /**
     * 使用中序遍历
     * */
    public int kthSmallestRe(BinarySearchTreeNode root, int k) {
        midOrder(root, k);
        return kthValue;
    }

    private void midOrder (BinarySearchTreeNode root, int k) {
        if (root == null) {
            return;
        }

        BinarySearchTreeNode left = root.left;
        if (left != null) {
            midOrder(left, k);
        }
        if (index >= k) {
            return;
        }
        index++;
        kthValue = root.value;
        BinarySearchTreeNode right = root.right;
        if (right!=null) {
            midOrder(right, k);
        }
    }

    /**
     * 不使用递归
     * */
    public int kthSmallest(BinarySearchTreeNode root, int k) {
        Stack<BinarySearchTreeNode> stack = new Stack<>();
        int count = 0;

        BinarySearchTreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                count++;
                if (count == k) {
                    return current.value;
                }
                current = current.right;
            }
        }

        return -1;
    }
}
