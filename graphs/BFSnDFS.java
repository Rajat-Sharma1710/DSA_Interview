package com.graphs;

import java.util.*;

import static com.graphs.UndirectedGraphsImpl.cyclicGraph;

public class BFSnDFS {
    static List<Integer> dfsList = new ArrayList<>();
    public static void main(String[] args) {
        List<List<Integer>> graph = cyclicGraph();
        List<Integer> ans = bfs(7, graph);
        System.out.println(ans);

//        boolean[] vis = new boolean[8];
//        dfs(graph, 7, 1, vis);
//        System.out.println(dfsList);
    }

    private static List<Integer> bfs(int vertices, List<List<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        // Condition is 1 based node indexing....
        queue.add(1);
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[vertices + 1];
        Arrays.fill(vis, false);
        vis[1] = true;
        while(!queue.isEmpty()){
            int rem = queue.poll();
            ans.add(rem);

            for(int node: graph.get(rem)){
                if(!vis[node]){
                    vis[node] = true;
                    queue.add(node);
                }
            }
        }
        return ans;
    }

    private static void dfs(List<List<Integer>> graph, int vertices, int node, boolean[] vis){
        dfsList.add(node);
        vis[node] = true;

        for(int vertex: graph.get(node)){
            if(!vis[vertex])
                dfs(graph, vertices, vertex, vis);
        }
    }
}
