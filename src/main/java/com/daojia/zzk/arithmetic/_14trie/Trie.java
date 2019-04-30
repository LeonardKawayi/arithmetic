package com.daojia.zzk.arithmetic._14trie;

/**
 * Trie 树
 * 时间复杂度：O(k)，k:查询的字符串长度
 */
public class Trie {

    /**
     *  存储无意义字符
     * */
    private TrieNode root = new TrieNode('/');

    /**
     *  往Trie树中插入一个字符串
     * */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     *  在Trie树中查找一个字符串
     * */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                // 不存在 pattern
                return false;
            }
            p = p.children[index];
        }
        // 不能完全匹配，只是前缀
        if (p.isEndingChar == false) return false;

        // 找到 pattern
        else return true;
    }
}

class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;
    public TrieNode(char data) {
        this.data = data;
    }
}

