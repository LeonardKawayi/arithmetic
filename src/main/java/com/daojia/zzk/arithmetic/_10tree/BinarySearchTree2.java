package com.daojia.zzk.arithmetic._10tree;

import java.util.Stack;

/**
 * @author zhangzk
 * 二叉查找树
 */
public class BinarySearchTree2 {

    /**
     * 二叉树的最大深度
     * */
    public int maxDeep (TreeNode2 root) {
        if (root == null) {
            return  0;
        }

        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }

    /**
     * 验证二叉树
     * */
    boolean isValidBinaryTree (TreeNode2 tree) {
        if (tree == null) {
            return false;
        }

        Stack<TreeNode2> stack = new Stack<>();
        TreeNode2 node = tree;
        TreeNode2 preNode = null;
        while(node != null || !stack.isEmpty()){
            stack.push(node);
            node = node.left;
            while(node == null && !stack.isEmpty()){
                node = stack.pop();
                if(preNode != null){
                    if(preNode.data >= node.data){
                        return false;
                    }
                }
                preNode = node;
                node = node.right;
            }
        }
        return true;
    }

    /**
     * 路径总和
     * */
    boolean hasPathNum (TreeNode2 tree, int num) {
        if (tree == null) {
            return false;
        }
        return hasPathSum(tree, tree.data, num);
    }

    public boolean hasPathSum(TreeNode2 root, int tmp, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return tmp == sum;
        }
        if (root.left == null) {
            return hasPathSum(root.right, root.right.data + tmp, sum);
        }
        if (root.right == null) {
            return hasPathSum(root.left, root.left.data + tmp, sum);
        }
        return hasPathSum(root.left, root.left.data + tmp, sum) ||
                hasPathSum(root.right, root.right.data + tmp, sum);
    }
}

class TreeNode2 {
    int data;

    TreeNode2 left;

    TreeNode2 right;

    public TreeNode2(int data) {
        this.data = data;
    }
}