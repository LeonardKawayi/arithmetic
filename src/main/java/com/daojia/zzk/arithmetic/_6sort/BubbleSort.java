package com.daojia.zzk.arithmetic._6sort;

/**
 * 冒泡排序
 * */
public class BubbleSort {

    /**
     * 冒泡排序
     * */
    public void bubbleSort (int[] array, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            // 提前退出的标记
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;

                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }
}
