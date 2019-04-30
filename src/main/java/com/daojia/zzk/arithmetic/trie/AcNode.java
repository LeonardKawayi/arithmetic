package com.daojia.zzk.arithmetic.trie;

/**
 * ac自动机
 * 多模式串匹配算法
 * ac自动机的构建：（1）将多个模式串构建成trie树；（2）在trie树上构建失败指针（相当于KMP中的失败函数next数组）
 */
public class AcNode {
    private char data;
    // 字符集只包含a~z这26个字符
    private AcNode[] children = new AcNode[26];
    // 结尾字符为true
    private boolean isEndingChar = false;

    // 当isEndingChar=true时，记录模式串长度
    private int length = -1;

    // 失败指针
    private AcNode fail;

    public AcNode(char data) {
        this.data = data;
    }
}
