package com.graphs.cycleDetection;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.graphs.UndirectedGraphsImpl.cyclicGraph;

public class CycleDetectionBFS {
    public static void main(String[] args) {
        boolean isCycle = isCycle(cyclicGraph());
        System.out.println(isCycle);
    }

    private static boolean isCycle(List<List<Integer>> adj) {
        int nodes = adj.size();
        boolean[] vis = new boolean[nodes];
        // This loop is running to cover all nodes in case of connected components
        for(int i = 1; i < nodes; i++){
            if(!vis[i]){
                if(detectCycle2(adj, vis, i))
                    return true;
            }
        }
        return false;
    }

    /*
       In this logic we are marking the node as visited when we are adding them to queue,
       so by this logic duplicate nodes won't be added to queue and have to used the parent
       child condition to detect cycle in graph
     */
    private static boolean detectCycle1(List<List<Integer>> adj, boolean[] vis, int vertex
    ) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(vertex, -1));
        vis[vertex] = true;

        while(!que.isEmpty()){
            Pair rem = que.poll();

            for(int child: adj.get(rem.node)){
                if(!vis[child]){
                    vis[child] = true;
                    que.add(new Pair(child, rem.node));
                } else if(child != rem.parent){
                    return true;
                }
            }
        }
        return false;
    }

    /*
        In this logic, we are marking the nodes visited when we are removing them
        out from the queue which is why duplicate nodes are allowed here
     */
    private static boolean detectCycle2(List<List<Integer>> adj, boolean[] vis, int vertex){
        Queue<Integer> que = new LinkedList<>();
        que.add(vertex);

        while(!que.isEmpty()){
            int pollNode = que.poll();
            // Since duplicates are allowed here, check the same
            if(vis[pollNode]) return true;
            vis[pollNode] = true;
            for(int child: adj.get(pollNode)){
                if(!vis[child]){
                    que.add(child);
                }
            }
        }
        return false;
    }

    static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
}
