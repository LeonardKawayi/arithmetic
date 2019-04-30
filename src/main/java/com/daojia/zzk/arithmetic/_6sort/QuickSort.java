package com.daojia.zzk.arithmetic._6sort;

/**
 * 快速排序算法
 */
public class QuickSort {
    
    public static void main(String[] args){
        int[] test = {9,2,6,3,5,7,10,11,12};
        quickSort(test);

        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    private static void quickSort (int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort (int[] array, int low, int high) {
        if (low >= high) return;

//        int index = partition(array, low, high);
        int index = partition2(array, low, high);
        quickSort(array, low, index-1);
        quickSort(array, index+1, high);
    }

    private static int partition(int[] array, int low, int high) {
        //固定的切分方式
        int key = array[low];

        while (low < high) {
            //从后半部分向前扫描
            while (array[high] >= key && high > low) {
                high--;
            }
            array[low] = array[high];

            // 从前半部分向后扫描
            while (array[low] <=key && high > low){
                low++;
            }
            array[high] = array[low];
        }

        array[high] = key;
        return high;
    }

    private static int partition2 (int[] array, int low, int high) {
        // 三数取中
        int mid = low + (high - low) / 2;
        if (array[mid] > array[high]) {
            swap(array[mid], array[high]);
        }

        if (array[low]>array[high]) {
            swap(array[low], array[high]);
        }

        // 确保key是三个数的中间值
        if (array[mid]>array[low]) {
            swap(array[mid], array[low]);
        }

        int key = array[low];
        while (low < high) {
            //从后半部分向前扫描
            while (array[high] >= key && high > low) {
                high--;
            }
            array[low] = array[high];

            // 从前半部分向后扫描
            while (array[low] <=key && high > low){
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }

    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
}
