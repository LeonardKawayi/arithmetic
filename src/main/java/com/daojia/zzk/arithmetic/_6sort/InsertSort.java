package com.daojia.zzk.arithmetic._6sort;

/**
 * @author zhangzk
 * 插入排序
 * 不需要额外的存储空间，空间复杂度时O(1),原地排序
 * 值相同的元素，顺序不交换，稳定的排序算法
 * 时间复杂度：最好：O(n)，最坏：O(n2)
 */
public class InsertSort {

    /**
     * 插入排序, 两种操作：元素的比较和移动
     * */
    static void insertSort (int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >=0; --j) {
                if (array[j] > value) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = value;
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{4,5,6,1,2,3};
        insertSort(array, array.length);

        for (int i : array) {
            System.out.println(i);
        }
    }
}
