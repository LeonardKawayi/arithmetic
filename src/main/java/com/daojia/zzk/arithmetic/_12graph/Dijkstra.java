package com.daojia.zzk.arithmetic._12graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangzk
 *         Dijkstra算法
 */
public class Dijkstra {

    /**
     * Dijkstra 算法最短路径
     * */
    public static Map<Integer, Integer> dijkstra(Graph graph, int startIndex) {
        //创建距离表，存储从起点到每一个顶点的临时距离
        Map<Integer, Integer> distanceMap = new HashMap<>();
        // 记录遍历过的顶点
        Set<Integer> accessedSet = new HashSet<>();

        // 图的顶点数量
        int size = graph.vertexes.length;

        //初始化最短路径表，到达每个顶点的路径代价默认为无穷大
        for (int i = 0; i < size; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }

        // 遍历起点，刷新距离表
        accessedSet.add(0);

        LinkedList<Edge> edgesFromStart = graph.adj[startIndex];

        for (Edge edge : edgesFromStart) {
            distanceMap.put(edge.index, edge.wight);
        }

        //主循环，重复 遍历最短距离顶点和刷新距离表 的操作
        for (int i = 0; i < size; i++) {
            //寻找最短距离顶点
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;

            for (int j = 1; j < size; j++) {
                if (!accessedSet.contains(j) && distanceMap.get(j) < minDistanceFromStart) {
                    minDistanceFromStart = distanceMap.get(j);
                    minDistanceIndex = j;
                }
            }

            if (minDistanceIndex == -1) {
                break;
            }

            //遍历顶点，刷新距离表
            accessedSet.add(minDistanceIndex);
            for (Edge edge : graph.adj[minDistanceIndex]) {
                if (accessedSet.contains(edge.index)) {
                    continue;
                }

                int wight = edge.wight;
                Integer preDistance = distanceMap.get(edge.index);
                if (wight < Integer.MAX_VALUE && minDistanceFromStart + wight < preDistance) {
                    distanceMap.put(edge.index, minDistanceFromStart + wight);
                }
            }
        }

        return distanceMap;
    }
    /**
     * 顶点内部类
     * */
    private static class Vertex {
        String data;

        public Vertex(String data) {
            this.data = data;
        }
    }

    /**
     * 边
     * */
    private static class Edge {
        int index;

        int wight;

        public Edge(int index, int wight) {
            this.index = index;
            this.wight = wight;
        }
    }

    /**
     * 图
     * */
    private static class Graph {
        private Vertex[] vertexes;

        private LinkedList<Edge> adj[];

        public Graph(int size) {
            vertexes = new Vertex[size];
            adj = new LinkedList[size];

            for (int i = 0; i < size; i++) {
                adj[i] = new LinkedList<>();
            }
        }
    }

    private static void initGraph (Graph graph) {
        graph.vertexes[0] = new Vertex("A");
        graph.vertexes[1] = new Vertex("B");
        graph.vertexes[2] = new Vertex("C");
        graph.vertexes[3] = new Vertex("D");
        graph.vertexes[4] = new Vertex("E");
        graph.vertexes[5] = new Vertex("F");
        graph.vertexes[6] = new Vertex("G");

        graph.adj[0].add(new Edge(1, 5));
        graph.adj[0].add(new Edge(2,2));
        graph.adj[1].add(new Edge(0,5));
        graph.adj[1].add(new Edge(3,1));
        graph.adj[1].add(new Edge(4,6));
        graph.adj[2].add(new Edge(0,2));
        graph.adj[2].add(new Edge(3,6));
        graph.adj[2].add(new Edge(5,8));
        graph.adj[3].add(new Edge(1,1));
        graph.adj[3].add(new Edge(2,6));
        graph.adj[3].add(new Edge(4,1));
        graph.adj[4].add(new Edge(1,6));
        graph.adj[4].add(new Edge(3,1));
        graph.adj[4].add(new Edge(6,7));
        graph.adj[5].add(new Edge(2,8));
        graph.adj[5].add(new Edge(3,2));
        graph.adj[5].add(new Edge(6,3));
        graph.adj[6].add(new Edge(4,7));
        graph.adj[6].add(new Edge(5,3));
    }
}
