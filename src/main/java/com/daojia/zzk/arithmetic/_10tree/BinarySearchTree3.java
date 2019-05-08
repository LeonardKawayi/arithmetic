package com.daojia.zzk.arithmetic._10tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhangzk
 * 二叉搜索树
 */
public class BinarySearchTree3 {

    /**
     * 前序遍历,递归实现
     * 父->左->右
     * */
    public static void preOrderRe (BinarySearchTreeNode node) {
        if (node != null) {
            System.out.println(node.value);
        }

        BinarySearchTreeNode left = node.left;
        if (left != null) {
            preOrderRe(left);
        }

        BinarySearchTreeNode right = node.right;
        if (right != null) {
            preOrderRe(right);
        }
    }

    /**
     * 前序遍历,非递归实现
     * */
    public static void preOrder (BinarySearchTreeNode node) {
        Stack<BinarySearchTreeNode> stack = new Stack<>();

        while (node != null || stack.isEmpty()) {
            while (node != null) {
                System.out.println(node.value);
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历,递归实现
     * 左->父->右
     * */
    public static void midOrderRe (BinarySearchTreeNode node) {
        BinarySearchTreeNode left = node.left;
        if (left != null) {
            midOrderRe(left);
        }
        System.out.println(node.value);
        BinarySearchTreeNode right = node.right;
        if (right != null) {
            midOrderRe(right);
        }
    }

    /**
     * 中序遍历,非递归实现
     * 左->父->右
     * */
    public static void midOrder (BinarySearchTreeNode node) {
        Stack<BinarySearchTreeNode> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历，首先遍历左子树，然后遍历右子树，最后访问根节点,递归实现
     * */
    private static void postOrderRe (BinarySearchTreeNode node) {
        if (node == null) {
            return;
        }

        postOrderRe(node.left);
        postOrderRe(node.right);
        System.out.println(node.value);
    }

    /**
     * 后序遍历，首先遍历左子树，然后遍历右子树，最后访问根节点,非递归实现
     * 左->右 ->父
     * */
    private static void postOrder (BinarySearchTreeNode biTree) {
        int left = 1;
        int right = 2;

        Stack<BinarySearchTreeNode> stack = new Stack<>();
        Stack<Integer> flagStack = new Stack<>();

        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null) {
                stack.push(biTree);
                flagStack.push(left);
                biTree = biTree.left;
            }

            while (!stack.isEmpty() && flagStack.peek() == right) {
                flagStack.pop();
                System.out.println(stack.pop().value);
            }

            if (!stack.isEmpty() && flagStack.peek() == left) {
                flagStack.pop();
                flagStack.push(right);
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
    private static void levelOrder (BinarySearchTreeNode biTree) {
        if (biTree != null) {
            LinkedList<BinarySearchTreeNode> list = new LinkedList<>();
            list.add(biTree);

            BinarySearchTreeNode current;
            while (!list.isEmpty()) {
                current = list.poll();

                System.out.println(current);
                if (current.left != null) {
                    list.add(current.left);
                }

                if (current.right != null) {
                    list.add(current.right);
                }
            }
        }
    }

    /**
     * 二叉树的最大深度
     * 左右子树中深度最大者 + 1
     * */
    public int maxDeep (BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }

    /**
     * 验证二叉树
     * 核心思想：中序遍历保证升序。
     * 在中序遍历中，保存上一个遍历的节点值，与当前节点比较，保证小于当前节点即可。
     * */
    int last = Integer.MIN_VALUE;
    boolean isFirst = true;
    boolean isValidBinaryTreeRe (BinarySearchTreeNode tree) {
        if (tree == null) {
            return true;
        }

        if (isValidBinaryTreeRe(tree.left)) {
            if (last < tree.value || isFirst) {
                isFirst = true;
                last = tree.value;
                return isValidBinaryTreeRe(tree.right);
            }
        }
        return false;
    }

    /**
     * 验证二叉树
     *1. 遍历每一个结点, 若都满足, 当前结点大于左子树中的最大值, 小于右子树中的最小值, 则说明为二叉搜索树
     *2. 中序遍历二叉搜索树, 若序列递增, 则说明为二叉搜索树
     * */
    boolean isValidBinaryTree (BinarySearchTreeNode tree) {
        Stack<BinarySearchTreeNode> stack = new Stack<>();

        BinarySearchTreeNode current = tree;
        BinarySearchTreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                if (prev != null) {
                    if (prev.value >= current.value) {
                        return false;
                    }
                }
                prev = current;
                current = current.right;
            }
        }

        return true;
    }

    /**
     * 路径总和 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * */
    boolean hasPathNum2 (BinarySearchTreeNode tree, int sum) {
        if (tree == null) return false;

        if (tree.left == null && tree.right == null) return tree.value == sum;

        return hasPathNum2(tree.left, sum-tree.value) || hasPathNum2(tree.right, sum-tree.value);
    }

    /**
     *  使用回溯法, 遍历每一条 root->leaf 的路线是否满足在和为 sum, 可以使用减枝操作
     * */
    boolean hasPathNum (BinarySearchTreeNode tree, int num) {
        if (tree == null) return false;
        return hasPathSum(tree, tree.value, num);
    }

    public boolean hasPathSum(BinarySearchTreeNode root, int tmp, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return tmp == sum;
        }

        if (root.left == null) {
            return hasPathSum(root.right, root.right.value+tmp, sum);
        }

        if (root.right == null) {
            return hasPathSum(root.left, root.left.value+tmp, sum);
        }
        return hasPathSum(root.right, root.left.value+tmp, sum) || hasPathSum(root.left, root.right.value+tmp, sum);
    }

    /**
     * 反转二叉树
     * */
    BinarySearchTreeNode reverseTree (BinarySearchTreeNode root) {
        LinkedList<BinarySearchTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinarySearchTreeNode current = root;

        while (!queue.isEmpty()) {
            current = queue.poll();

            BinarySearchTreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return root;
    }
}
