package com.graphs.cycleDetection;

import java.util.List;

import static com.graphs.UndirectedGraphsImpl.*;

public class CycleDetectionDFS {
    public static void main(String[] args) {
        List<List<Integer>> adjList = cyclicGraph();
//        boolean ans = isCycle(adjList);
//        boolean ans = isCycle(simpleLineGraph());
        boolean ans = isCycle(anotherCyclic());
        System.out.println(ans);
    }

    private static boolean isCycle(List<List<Integer>> adj) {
        int nodes = adj.size();
        boolean[] vis = new boolean[nodes];
        for(int i = 1; i < nodes; i++){
            if(!vis[i]){
                if(detectCycle(adj, vis, i, -1))
                    return true;
            }
        }
        return false;
    }

    private static boolean detectCycle(List<List<Integer>> adj, boolean[] vis, int vertex
    , int parent) {
        vis[vertex] = true;
        for(int child: adj.get(vertex)) {
            if (!vis[child]) {
                if(detectCycle(adj, vis, child, vertex))
                    return true;
            } else if (parent != child) {
                return true;
            }
        }
        return false;
    }
}
