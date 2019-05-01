package com.daojia.zzk.arithmetic._12graph;

import java.util.LinkedList;

/**
 * @author zhangzk
 * A*搜索算法
 */
public class AStar {

    private LinkedList<Edge> adj[]; // 邻接表
    private int v; // 顶点个数
    // Graph 类的成员变量，在构造函数中初始化
    private Vertex[] vertexes;

    // 新增一个方法，添加顶点的坐标
    public void addVetex(int id, int x, int y) {
        vertexes[id] = new Vertex(id, x, y);
    }

    public AStar(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        vertexes = new Vertex[this.v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) { // 添加一条边
        this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge {
        public int sid; // 边的起始顶点编号
        public int tid; // 边的终止顶点编号
        public int w; // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    // 下面这个类是为了 dijkstra 实现用的
    private class Vertex {
        public int id; // 顶点编号 ID
        public int dist; // 从起始顶点，到这个顶点的距离，也就是 g(i)
        public int f; // 新增：f(i)=g(i)+h(i)
        public int x, y; // 新增：顶点在地图中的坐标（x, y）
        public Vertex(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.f = Integer.MAX_VALUE;
            this.dist = Integer.MAX_VALUE;
        }
    }

    // 因为 Java 提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
    private class PriorityQueue { // 根据 vertex.dist 构建小顶堆
        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll() {
            for (int i = 1; i < count; i++) {
                nodes[i-1] = nodes[i];
            }
            return nodes[0];
        }

        public void add(Vertex vertex) {
            nodes[count] = vertex;
            count++;
        }

        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度 O(logn)。
        public void update(Vertex vertex) {
        }

        public boolean isEmpty() {
            return false;
        }

        public void clear () {
            nodes = new Vertex[v + 1];
            this.count = 0;
        }
    }

    public void astar(int s, int t) { // 从顶点 s 到顶点 t 的路径
        int[] predecessor = new int[this.v]; // 用来还原路径
        // 按照 vertex 的 f 值构建的小顶堆，而不是按照 dist
        PriorityQueue queue = new PriorityQueue(this.v);
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
        vertexes[s].dist = 0;
        vertexes[s].f = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll(); // 取堆顶元素并删除
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i); // 取出一条 minVetex 相连的边
                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) { // 更新 next 的 dist,f
                    nextVertex.dist = minVertex.dist + e.w;
                    nextVertex.f
                            = nextVertex.dist+hManhattan(nextVertex, vertexes[t]);
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id] == true) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
                if (nextVertex.id == t) { // 只要到达 t 就可以结束 while 了
                    queue.clear(); // 清空 queue，才能推出 while 循环
                    break;
                }
            }
        }
        // 输出路径
        System.out.print(s);
        print(s, t, predecessor); // print 函数请参看 Dijkstra 算法的实现
    }

    int hManhattan(Vertex v1, Vertex v2) { // Vertex 表示顶点，后面有定义
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }
}
