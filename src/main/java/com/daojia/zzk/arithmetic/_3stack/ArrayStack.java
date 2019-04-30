package com.daojia.zzk.arithmetic._3stack;

/**
 * @author zhangzk
 * 基于数组实现的顺序栈
 */
public class ArrayStack {
    private String[] items; // 数组
    private int count; // 栈中元素个数
    private int n; // 栈的大小

    /**
     * 初始化数组，申请一个大小为 n 的数组空间
     * */
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 入栈操作
     * */
    public boolean push(String item) {
        // 数组空间不够了，返回false，入栈失败
        if (count == n) {
            return false;
        }

        // 将item放到下表为count的位置，并且count加一
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     */
    public String pop () {
        //如果栈为空，则返回null
        if (count == 0) {
            return "";
        }

        //返回下表为count-1的数组元素，并将占中元素个数-1
        String tmp = items[count - 1];
        --count;
        return tmp;

    }

    public static void main(String[] args){
        ArrayStack as =  new ArrayStack(8);
        as.push("0");
        as.push("1");
        as.push("2");
        as.push("3");

        as.pop();
    }
}
