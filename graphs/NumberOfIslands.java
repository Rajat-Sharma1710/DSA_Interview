package com.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfIslands {
    public static void main(String[] args) {
        List<List<Integer>> adj = UndirectedGraphsImpl.normalShape();
        boolean[] vis = new boolean[adj.size()];
        System.out.print(func(adj, 1, vis));
    }

    static String func(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        List<String> children = new ArrayList<>();
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                children.add(func(graph, neighbor, visited));
            }
        }
        Collections.sort(children); // Ensure consistent ordering
        return "(" + String.join("", children) + ")";
    }
}
