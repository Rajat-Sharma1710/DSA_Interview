package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static com.graphs.UndirectedGraphsImpl.getPrimsGraph;

public class PrimsMST {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair1>> adj = getPrimsGraph();
        int ans = spanningTree(5, 6, adj);
        System.out.println(ans);
    }

    private static int spanningTree(int V, int E, ArrayList<ArrayList<Pair1>> adj) {
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) ->
                a1[0] - a2[0]);

        pq.add(new int[]{0, 0, -1});
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] out = pq.poll();
            int wei = out[0];
            int node = out[1];
            int parent = out[2];

            if (!vis[node]) {
                vis[node] = true;

                for (Pair1 arr : adj.get(node)) {
                    int to = arr.node;
                    int weiLocal = arr.wei;

                    if (!vis[to]) {
                        pq.add(new int[]{weiLocal, to, node});
                    }
                }

                if (parent != -1) {
                    ans += wei;
                }
            }
        }
        return ans;
    }
}