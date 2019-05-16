package com.daojia.zzk.arithmetic._14trie;

/**
 * Created by zhangzk on 2019/5/16.
 */
public class Trie2 {

    TreeNode root = new TreeNode('/');

    public void insert (String word) {
        TreeNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null) {
                TreeNode node = new TreeNode(c);
                p.next[index] = node;
            }
            p = p.next[index];
        }
        p.isEncodingChar = true;
    }

    public boolean search (String word) {
        TreeNode p = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null) {
                return false;
            }
            p = p.next[index];
        }
        if (!p.isEncodingChar) return false;
        else return true;
    }

    public boolean startWith (String prefix) {
        TreeNode p = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (p.next[index] == null) {
                return false;
            }
            p = p.next[index];
        }
        return true;
    }

    class TreeNode {
        public char data;
        public TreeNode[] next = new TreeNode[26];
        public boolean isEncodingChar = false;
        public TreeNode(char data) {
            this.data = data;
        }
    }
}
