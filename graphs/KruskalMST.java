package com.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalMST {
    public static void main(String[] args) {
        int v = 8, e = 8; // this is for arr, e = 9 for arr1
        int[][] arr = {{0, 4, 6},
                {0, 2, 2},
                {2, 6, 3},
                {6, 5, 5},
                {6, 7, 4},
                {5, 7, 4},
                {0, 3, 7},
                {3, 1, 6}};

        int[][] arr1 = {{0, 2, 1},
                {2, 6, 3},
                {6, 4, 5},
                {4, 7, 1},
                {5, 6, 9},
                {5, 1, 4},
                {3, 7, 6},
                {1, 3, 3},
                {5, 7, 1}};

        List<Edge> adj = new ArrayList<>();
        for(int i = 0; i < e; i++){
            adj.add(new Edge(arr[i][2], arr[i][0], arr[i][1]));
        }

        int minWei = mst(adj, v);
        System.out.println(minWei);
    }

    private static int mst(List<Edge> adj, int v) {
        Collections.sort(adj);
        DSU obj = new DSU(v);

        int ans = 0;
        for(Edge edge: adj) {
            int wei = edge.wei;

            if(obj.findUltimateParent(edge.u) != obj.findUltimateParent(edge.v)) {
                obj.unionBySize(edge.u, edge.v);
                ans += wei;
            }
        }

        return ans;
    }
}

class Edge implements Comparable<Edge> {
    int wei, u, v;

    public Edge(int wei, int u, int v) {
        this.wei = wei;
        this.u = u;
        this.v = v;
    }

    public int compareTo(Edge e1) {
        return this.wei - e1.wei;
    }
}

