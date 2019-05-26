package com.daojia.zzk.arithmetic._6sort;

/**
 * 归并排序
 * 分治思想，分而治之。
 * 稳定的排序算法
 * 排序的时间复杂度是 O(nlogn)
 * 不是原地排序算法,需要借助额外空间的排序算法
 */
public class MergeSort {

    public static void mergerSort (int[] array) {
        mergerSort(array, 0, array.length - 1);
    }

    public static void mergerSort (int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) >> 1;
            // 左边归并排序，使得左子序列有序
            mergerSort(array, left, mid);
            // 右边归并排序，是的右子序列有序
            mergerSort(array, mid + 1, right);

            // 合并两个子序列
            merger(array, left, mid, right);
        }
    }

    public static void merger (int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=right){
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while(j<=right){
            temp[k++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }
    }
    
    public static void main(String[] args){
        int[] test = {9,2,6,3,5,7,10,11,12};
        mergerSort(test);

        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

}
