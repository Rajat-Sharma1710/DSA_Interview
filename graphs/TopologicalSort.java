package com.graphs;

import java.util.ArrayList;

import static com.graphs.directed.DirectedGraphsImpl.topo1;
import static com.graphs.directed.DirectedGraphsImpl.topo2;

public class TopologicalSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = topo1();
        System.out.println(adj);
        int len = adj.size();
        // vertices started from 0 to len - 1

        int[] vis = new int[len];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(vis[i] == 0) {
                vis[i] = 1;
                func(adj, len, vis, i, ans);
            }
        }
        reverse(ans);
        System.out.println(ans);
    }

    private static void reverse(ArrayList<Integer> ans) {
        int i = 0, j = ans.size() - 1;
        while(i < j){
            int temp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, temp);
            i++; j--;
        }
    }

    static void func(ArrayList<ArrayList<Integer>> adj, int len,
                    int[] vis, int vertex, ArrayList<Integer> list) {

        for(int node: adj.get(vertex)) {
            if(vis[node] == 0){
                vis[node] = 1;
                func(adj, len, vis, node, list);
            }
        }
        list.add(vertex);
    }
}
