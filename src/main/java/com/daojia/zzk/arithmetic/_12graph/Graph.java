package com.daojia.zzk.arithmetic._12graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 *
 */
public class Graph {

    /**
     *  顶点的个数
     * */
    private int v;

    /**
     * 邻接表
     * */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     * */
    private void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * 广度优先搜索(暴力搜索)
     * s为起始顶点，t为终止顶点。搜索一条从s到t的路径。这样球的的路径是s到t的最短路径
     * 时间复杂度是O(V+E) v:顶点个数 E:边的个数
     * 空间复杂度：visited数组，queue队列，prev数组,这三个存储空间的大小都不会超过顶点的个数，所以空间复杂度：O(V)
     * */
    public void bfs(int s, int t) {
        if (s == t) return;
        //visited是用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点q被访问，那相应的visited[q]会被设置为true
        boolean[] visited = new boolean[v];
        visited[s]=true;
        /**
         * 用来存储已经被访问、但相连的顶点还没有被访问的顶点。因为广度优先搜索是逐层访问的，我们只有把第 k 层的顶点都访问完成之后，才能访问第 k+1 层的顶点。
         *  当我们访问到第k层的顶点的时候，我们需要把第k层的顶顶点记录下来，稍后才能通过第k层的顶点来找第k+1层顶点。所以，我们用这个队列来实现记录的功能。
         */
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        /**
         * prev用来记录搜索路径。当我们从顶点s开始，广度优先搜索到顶点t后，prev 数组中存储的就是搜索的路径。不过，这个路径是反向存储的。
         * prev[w] 存储的是，顶点w是从哪个前驱顶点遍历过来来的。比如，我们通过顶点2的邻接表访问到顶点3，那prev[3]就等于 2。
         * */
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    /**
     *  全局变量或者类成员变量,当我们找到终止顶点t后，就不再递归继续查找
     * */
    boolean found = false;

    /**
     * 深度优先搜索,回溯思想(暴力搜索)
     * 时间复杂度：O(E)
     * 空间复杂度：O(V)
     * */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    /**
     * Dijkstra最短路径算法
     * https://mp.weixin.qq.com/s/lsd2YxZmr9LND6NIc7X-pQ
     * */



}
