package com.daojia.zzk.arithmetic._10tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhangzk
 * 二叉查找树
 */
public class BinarySearchTree2 {

    /**
     * 二叉树的最大深度
     * 左右子树中深度最大者 + 1
     * */
    public int maxDeep (TreeNode2 root) {
        if (root == null) {
            return  0;
        }

        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }

    /**
     * 验证二叉树
     * 核心思想：中序遍历保证升序。
     * 在中序遍历中，保存上一个遍历的节点值，与当前节点比较，保证小于当前节点即可。
     * */
    int last;
    boolean isFirst = true;
    boolean isValidBinaryTree2 (TreeNode2 tree) {
        if (tree == null) {
            return true;
        }

        if (isValidBinaryTree2(tree.left)) {
            if (last < tree.data || isFirst) {
                isFirst = false;
                last = tree.data;
                return isValidBinaryTree2(tree.right);
            }
        }

        return false;
    }

    /**
     * 验证二叉树
     *1. 遍历每一个结点, 若都满足, 当前结点大于左子树中的最大值, 小于右子树中的最小值, 则说明为二叉搜索树
     *2. 中序遍历二叉搜索树, 若序列递增, 则说明为二叉搜索树
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
     * 路径总和 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * */
    boolean hasPathNum2 (TreeNode2 tree, int sum) {
        if (tree == null) return false;

        if (tree.left == null && tree.right == null) return sum == tree.data;

        return hasPathNum2(tree.left, sum-tree.data) || hasPathNum2(tree.right, sum - tree.data);
    }


    /**
     *  使用回溯法, 遍历每一条 root->leaf 的路线是否满足在和为 sum, 可以使用减枝操作
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


    /**
     * 反转二叉树
     * */
    TreeNode2 insertTree (TreeNode2 root) {
        if (root == null) return root;
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.add(root);

        TreeNode2 node = root;
        while (!queue.isEmpty()) {
            node = queue.poll();
            TreeNode2 tmpNode = node.left;
            node.left = node.right;
            node.right = tmpNode;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
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