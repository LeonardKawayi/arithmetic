package com.daojia.zzk.arithmetic._10tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树
 */
public class BinaryTree {

    /**
     * 前序遍历,先遍历根节点，然后遍历左子树，最后遍历右子树,递归实现
     * */
    private static void preOrderRe (TreeNode biTree) {
        System.out.println(biTree.value);
        TreeNode left = biTree.left;
        if (left != null) {
            preOrderRe(left);
        }
        TreeNode right = biTree.right;
        if (right != null) {
            preOrderRe(right);
        }
    }

    /**
     * 前序遍历,先遍历根节点，然后遍历左子树，最后遍历右子树,非递归实现
     * */
    private static void preOrder (TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<>();

        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                System.out.println(biTree.value);
                stack.push(biTree);
                biTree = biTree.left;
            }

            if (!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }

    /**
     * 中序遍历，先遍历左子树，然后访问根节点，最后遍历右子树,递归实现
     * */
    private static void midOrderRe (TreeNode biTree) {
        if (biTree != null) {
            midOrderRe(biTree.left);
            System.out.println(biTree.value);
            midOrderRe(biTree.right);
        }
    }

    /**
     * 中序遍历，先遍历左子树，然后访问根节点，最后遍历右子树,非递归实现
     * */
    private static void midOrder (TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<>();

        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()) {
                biTree = stack.pop();
                System.out.println(biTree.value);
                biTree = biTree.right;
            }
        }
    }

    /**
     * 后序遍历，首先遍历左子树，然后遍历右子树，最后访问根节点,递归实现
     * */
    private static void postOrderRe (TreeNode biTree) {
        if (biTree != null) {
            postOrderRe(biTree.left);
            postOrderRe(biTree.right);
            System.out.println(biTree.value);
        }
    }

    /**
     * 后序遍历，首先遍历左子树，然后遍历右子树，最后访问根节点,非递归实现
     * */
    private static void postOrder (TreeNode biTree) {
        // 在辅助栈里表示左节点
        int left = 1;
        // 在辅助栈里表示右节点
        int right = 2;
        Stack<TreeNode> stack = new Stack<>();
        //辅助栈，用来判断子节点返回父节点时处于左节点还是右节点
        Stack<Integer> stack1 = new Stack<>();
        while (biTree != null || !stack.empty()) {
            while (biTree != null) {
                //将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack1.push(left);
                biTree = biTree.left;
            }

            while (!stack.empty() && stack1.peek() == right) {
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack1.pop();
                System.out.println(stack.pop().value);
            }

            if (!stack.empty() && stack1.peek() == left) {
                stack1.pop();
                stack1.push(right);
                biTree = stack.peek().right;
            }
        }
    }

    /**
     * 层序遍历
     * 1.对于不为空的结点，先把该结点加入到队列中
     * 2.从队中拿出结点，如果该结点的左右结点不为空，就分别把左右结点加入到队列中
     * 3.重复以上操作直到队列为空
     * */
    private static void levelOrder (TreeNode biTree) {
        if (biTree != null) {
            LinkedList<TreeNode> list = new LinkedList<>();
            list.add(biTree);

            TreeNode currentNode;
            while (!list.isEmpty()) {
                currentNode = list.poll();
                System.out.println(currentNode);
                if (currentNode.left != null) {
                    list.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    list.add(currentNode.right);
                }
            }
        }
    }
}

/**
 * 节点结构
 */
class TreeNode {
    int value;

    TreeNode left;

    TreeNode right;

    TreeNode (int value) {
        this.value = value;
    }
}
