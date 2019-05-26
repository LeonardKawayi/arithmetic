package com.daojia.zzk.arithmetic._10tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzk
 * 二叉搜索树中第k大
 */
public class KthBiggest {
    private List<BinarySearchTreeNode> list = new ArrayList<>();

    BinarySearchTreeNode FindKthLargest (int k) {
        if (k <= 0) return null;
        if (k > list.size()) return null;

        return list.get(k-1);
    }

    private void midOrder (BinarySearchTreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            midOrder(root.left);
        }
        list.add(root);
        if (root.right != null) {
            midOrder(root.right);
        }
    }
}
