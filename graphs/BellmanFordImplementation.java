package com.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordImplementation {
    public static void main(String[] args) {
        int[][] edges ={{0,1,5}, {1,0,3}, {1,2,-1}, {2,0,1}};
        int[] ans = bellmanFord(3, edges, 2);

        for(int ele: ans) {
            System.out.print(ele + " ");
        }
    }

    private static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here

        int[] vertices = new int[V];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int wei = edges[i][2];

            adj.get(from).add(new int[]{to, wei});
        }
        int[] dis = new int[V];
        Arrays.fill(dis, (int)1e8);
        dis[src] = 0;
        // N - 1 Iterations....
        for(int i = 0; i < V - 1; i++) {
            for(int[] arr: edges) {
                int from = arr[0];
                int to = arr[1];
                int wei = arr[2];
                if(dis[from] != 1e8 && dis[from] + wei < dis[to]) {
                    dis[to] = dis[from] + wei;
                }
            }
        }

        for(int[] arr: edges) {
            int from = arr[0];
            int to = arr[1];
            int wei = arr[2];
            if(dis[from] != 1e8 && dis[from] + wei < dis[to]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dis;
    }
}
