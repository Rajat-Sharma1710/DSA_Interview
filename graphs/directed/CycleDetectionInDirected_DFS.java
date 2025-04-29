package com.graphs.directed;

import java.util.ArrayList;
import static com.graphs.directed.DirectedGraphsImpl.topo1_cycle;

public class CycleDetectionInDirected_DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = topo1_cycle();
        System.out.println(adj);
        boolean[] vis = new boolean[adj.size()];
        boolean[] pathVis = new boolean[adj.size()];
        boolean isCycle = false;
        for(int i = 0; i < adj.size(); i++){
            if(!vis[i]){
                vis[i] = true;
                pathVis[i] = true;
                if(isCycle(adj, i, vis, pathVis)) {
                    isCycle = true;
                    break;
                }
            }
        }

        System.out.println(isCycle);
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] vis,
                                   boolean[] pathVis) {

        for(int ele: adj.get(vertex)) {
            if(!vis[ele]){
                vis[ele] = true;
                pathVis[ele] = true;
                if(isCycle(adj, ele, vis, pathVis)){
                    return true;
                }
            } else if(pathVis[ele]){
                return true;
            }
        }

        pathVis[vertex] = false;
        return false;
    }
}
