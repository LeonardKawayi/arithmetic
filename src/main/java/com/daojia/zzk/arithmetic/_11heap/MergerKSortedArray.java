package com.daojia.zzk.arithmetic._11heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangzk
 * 利用优先级队列（堆）合并k个有序数组
 * 输入：
 * [
 *   [1, 3, 5, 7],
 *   [2, 4, 6],
 *   [0, 8, 9, 10, 11]
 * ]
 *
 * 输出：
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 * 在 O(Nlogk) 的时间复杂度内完成：
 * N是所有数组包含的整数个数。
 * k是数组的个数。
 *
 * 里路：
 * 1、最简单的方法是创建一个N大小的数组，然后把所有数字拷贝进去，然后再进行时间复杂度为O(NlogN)排序算法，这样总体时间复杂度为O(NlogN)
 * 2、可以利用最小堆完成，时间复杂度是O(Nlogk)，具体过程如下：
 *    （1）创建一个大小为N的数组保存最后的结果
 *    （2）数组本身已经从小到大排好序，所以我们只需创建一个大小为k的最小堆，堆中初始元素为k个数组中的每个数组的第一个元素，
 *    每次从堆中取出最小元素（堆顶元素），并将其存入输出数组中，将堆顶元素所在行的下一元素加入堆，重新排列出堆顶元素，
 *    时间复杂度为logk，总共N个元素，所以总体时间复杂度是Nlogk
 */
public class MergerKSortedArray {
    // 从小到大排序
    private Comparator<Element> ElementComparator = new Comparator<Element>() {

        @Override
        public int compare(Element left, Element right) {
            return left.val - right.val;
        }
    };

    int[] mergerKArrays (int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }

        int totalSize = 0;

        // 优先级队列（实际上跟小顶堆一样）
        Queue<Element> queue = new PriorityQueue<>(arrays.length, ElementComparator);

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element element = new Element(i, 0, arrays[i][0]);
                queue.add(element);
                totalSize +=arrays[i].length;
            }
        }

        int[] result = new int[totalSize];
        int index = 0;
        while (!queue.isEmpty()) {
            Element poll = queue.poll();
            result[index++] = poll.val;
            if (poll.col + 1 < arrays[poll.row].length) {
                Element next = new Element(poll.row, poll.col + 1, arrays[poll.row][poll.col + 1]);
                queue.add(next);
            }
        }

        return result;
    }
}

/**
 * 用于存放数组元素信息
 * k个有序数组就是一个二维数组
 * row: 当前遍历到元素的数组下标, 用以从此数组中取出当前元素
 * col: 当前元素位于此数组的下标
 * val:值
 * */
class Element {
    int row;

    int col;

    int val;

    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
