package com.graphs.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestDistanceInDAG {
    public static void main(String[] args) {
        int[][] edges = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
        int v = 6, e = 5;

        int[] ans = shortestDistance(edges, v, e);

        for(int i = 0; i < ans.length; i++){
            if(ans[i] >= 1e9) ans[i] = -1;
            System.out.print(ans[i] + " ");
        }
    }

    private static int[] shortestDistance(int[][] edges, int v, int e) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr: edges) {
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];

        for(int i = 0; i < v; i++) {
            if(!vis[i]){
                topo(adj, st, i, vis);
            }
        }

        // take the node and relax the edges...
        int[] shorDis = new int[v];
        Arrays.fill(shorDis, (int) 1e9);
        shorDis[0] = 0;
        while(!st.isEmpty()) {
            int ele = st.pop();

            for(Pair p: adj.get(ele)){
                if(shorDis[ele] + p.wei < shorDis[p.v]){
                    shorDis[p.v] = shorDis[ele] + p.wei;
                }
            }
        }

        return shorDis;
    }

    private static void topo(ArrayList<ArrayList<Pair>> adj, Stack<Integer> st, int vertex,
                             boolean[] vis) {

        for(Pair p: adj.get(vertex)) {
            if(!vis[p.v]){
                topo(adj, st, p.v, vis);
            }
        }

        st.push(vertex);
    }
}

class Pair {
    int v, wei;
    public Pair(int v, int wei) {
        this.v = v;
        this.wei = wei;
    }
}
