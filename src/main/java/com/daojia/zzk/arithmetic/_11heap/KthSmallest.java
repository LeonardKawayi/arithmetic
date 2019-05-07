package com.daojia.zzk.arithmetic._11heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangzk
 * 有序矩阵中第K小的元素
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 *  ],
 *   k = 8,
 *   返回 13。
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> queue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.val - o1.val;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Element element = new Element(i, j, matrix[i][j]);
                queue.offer(element);

                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        return queue.peek().val;
    }

    static class Element {
        int row;
        int col;
        int val;

        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
