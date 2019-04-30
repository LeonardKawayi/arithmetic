package com.daojia.zzk.arithmetic._1array;

/**
 * 数组的增加、删除、按照下标查找
 */
public class Array {
    // int类型的数组
    private int[] data;

    //数组的容量大小
    private int n;

    // 当前数据个数
    private int count;

    // 构造
    public Array(int capacity) {
        data = new int[capacity];
        this.n = capacity;
        this.count=0;
    }

    // 根据下标查找
    public int find (int index) {
        if (index < 0 || index >=n) return -1;
        return data[index];
    }

    /**
     *  按照下标插入
     * */
    public boolean insert (int index, int value) {
        // 判断是否满了
        if (count == n) {
            System.out.println("已满");
            return false;
        }
        /**
         * 未满
         * 判断位置是否合法
         * */
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }

        // 位置合法,从后往前搬移
        for (int i = count; i > index ; --i) {
            data[i] = data[i-1];
        }

        data[index] = value;
        ++count;
        return true;
    }

    /**
     * 删除
     * */
    public boolean delete (int index) {
        // 数组是否有数据
        if (count == 0) {
            System.out.println("数组中没有数据");
            return false;
        }

        // 位置是否合法
        if (index >= count || index < 0) {
            System.out.println("位置不合法");
            return false;
        }

        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }

        --count;
        return true;
    }

    /**
     * 输出
     * */
    public void printAll () {
        for (int i = 0; i < count; i++) {
            System.out.println("下表为：" + i + "， 数据是: " + data[i]);
        }
    }
    
    public static void main(String[] args){
        Array array = new Array(5);
        array.insert(0,0);
        array.insert(3, 3);
    }
}
