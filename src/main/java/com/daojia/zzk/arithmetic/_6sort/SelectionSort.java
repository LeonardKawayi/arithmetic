package com.daojia.zzk.arithmetic._6sort;

/**
 * 选择排序
 * 空间复杂度O(1)
 * 时间复杂度：O(n2)
 * 不是稳定的排序算法
 */
public class SelectionSort {

    public void selectionSort (int[] array, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            for (int j = i +1;  j < n; ++j) {
                if (array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    /**
     * 算法改进
     * 设置一个标记为，每次标记较小的元素所在的位置，直到找到最小的元素位置，然后直接进行交换即可
     * */
    public void selectionSort2 (int[] array, int n) {
        if (n <= 1) return;

        int minLocation = 0;

        for (int i = 0; i < n; i++) {
            minLocation = i;

            for (int j = i +1; j < n; ++j) {
                if (array[j] < array[minLocation]) {
                    minLocation = j;
                }
            }
            if (minLocation != i) {
                int tmp = array[minLocation];
                array[minLocation] = array[i];
                array[i] = tmp;
            }
        }
    }

}
