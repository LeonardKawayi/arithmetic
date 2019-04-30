package com.daojia.zzk.arithmetic._1array;

/**
 * 实现一个大小固定的有序(从小到大)数组，支持动态增删改操作
 */
public class SortedArray {
    private int[] data;

    private int size;

    public SortedArray(int capacity) {
        data = new int[capacity];
        this.size = 0;
    }

    public void insertValue (int value) {
        int insertIndex = findInsertIndex(value);
        insert(insertIndex, value);
    }

    private int findInsertIndex (int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] >= value) {
                return i;
            }
        }

        return size;
    }

    /**
     * 先用findInsertIndex找到插入的下标
     * 时间复杂度O(n)
     * */
    private void insert (int index, int value) {
        checkIndex(index);

        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }

        data[index] = value;
        size++;
    }

    public int remove (int index) {
        checkRemoveIndex(index);

        int result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }

        size--;
        return result;
    }

    private void checkRemoveIndex (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove index error");
        }
    }

    private void checkIndex (int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("insert index error");
        }
    }

    public static void main(String[] args){
        SortedArray sortedArray = new SortedArray(10);
        sortedArray.insertValue(1);
        sortedArray.insertValue(5);
        sortedArray.insertValue(4);
        sortedArray.insertValue(9);

        for (int i = 0; i < sortedArray.data.length; i++) {
            System.out.println("i: " + i + "data: " + sortedArray.data[i]);
        }
    }

}
