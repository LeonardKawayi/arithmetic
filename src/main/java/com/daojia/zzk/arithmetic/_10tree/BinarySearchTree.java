package com.daojia.zzk.arithmetic._10tree;

/**
 * 二叉查找树
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。
 */
public class BinarySearchTree {

    /**
     * 二叉查找树插入
     * */
    private void insert (Node tree, int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        while (tree != null) {
            if (data > tree.data) {
                if (tree.right == null) {
                    tree.right = new Node(data);
                    return;
                }
                tree = tree.right;
            } else { // data < tree.data
                if (tree.left == null) {
                    tree.left = new Node(data);
                    return;
                }
                tree = tree.left;
            }
        }
    }

    /**
     * 删除
     * */
    private void delete(Node tree, int data) {
        // 指向要删除的节点，初始化指向根节点
        Node p = tree;
        // pp 记录的是p的父节点
        Node pp = null;
        while (p!=null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // 没有找到
        if (p == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // 查找右子树中最小节点
            Node minP = p.right;
            // minPP表示minP的父节点
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将minP的数据替换到p中
            p.data= minP.data;
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            // 删除的是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    /**
     * 查找
     * */
    private Node find (Node tree, int data) {
        while (tree != null) {
            if (data < tree.data) {
                tree = tree.left;
            } else if (data > tree.data) {
                tree = tree.right;
            } else {
                return tree;
            }
        }
        return null;
    }

}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}