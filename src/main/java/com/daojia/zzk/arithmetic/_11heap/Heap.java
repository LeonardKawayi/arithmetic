package com.daojia.zzk.arithmetic._11heap;

/**
 * 堆--大顶堆
 */
public class Heap {
    // 数组，从下标 1 开始存储数据
    private int[] a;
    // 堆可以存储的最大数据个数
    private int n;
    // 堆中已经存储的数据个数
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        // 堆满了
        if (count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        // 自下往上堆化
        while (i/2 > 0 && a[i] > a[i/2]) {
            // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
            swap(a, i, i/2);
            i = i/2;
        }
    }

    private static void swap (int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public void removeMax() {
        // 堆中没有数据
        if (count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     *  自上往下堆化
     * */
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 建堆
     * */
    private static void buildHeap (int[] a, int n) {
        for (int i = n/2; i>=1;--i) {
            heapify(a, n, i);
        }
    }

    /**
     * 排序
     * */
    private static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k ,1);
        }
    }
}

