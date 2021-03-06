package com.daojia.zzk.arithmetic._10tree;

/**
 * @author zhangzk
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 */
public class LowestCommonAncestor {

    /**
     注意p,q必然存在树内, 且所有节点的值唯一!!!
     递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
     表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
     1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
     2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
     3. 左右子树返回值均为null, p和q均不在树中, 返回null
     **/
    public BinarySearchTreeNode lowestCommonAncestor(BinarySearchTreeNode root, BinarySearchTreeNode p, BinarySearchTreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        BinarySearchTreeNode left = lowestCommonAncestor(root.left, p, q);
        BinarySearchTreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }

    public BinarySearchTreeNode lowestCommonAncestor2(BinarySearchTreeNode root, BinarySearchTreeNode p, BinarySearchTreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.value < root.value && q.value < root.value) {
            return lowestCommonAncestor2(root.left, p, q);
        } else if (p.value > root.value && q.value > root.value) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return root;
        }
    }
}
