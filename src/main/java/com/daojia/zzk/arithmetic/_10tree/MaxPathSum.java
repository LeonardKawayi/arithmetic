package com.daojia.zzk.arithmetic._10tree;

/**
 * @author zhangzk
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 输入: [-10,9,20,null,null,15,7]
    -10
    / \
    9  20
    /  \
    15   7
    输出: 42
 */
public class MaxPathSum {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
         2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
         **/
        getMax(root);
        return res;
    }

    private int getMax(BinarySearchTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int left = Math.max(0, getMax(treeNode.left));
        int right = Math.max(0, getMax(treeNode.right));
        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        res = Math.max(res, left + treeNode.value + right);
        return Math.max(left, right) + treeNode.value;
    }
}
