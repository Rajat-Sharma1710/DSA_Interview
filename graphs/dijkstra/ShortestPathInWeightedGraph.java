package com.graphs.dijkstra;

import java.util.*;

public class ShortestPathInWeightedGraph {
    public static void main(String[] args) {
        int n = 18, m = 11;

        int[][] edges = {{4, 2, 4},
                {8, 11, 8},
                {6, 2, 6},
                {1, 11, 1},
                {6, 18, 6},
                {15, 16, 15},
                {2, 1, 2},
                {3, 6, 3},
                {11, 15, 11},
                {18, 11, 18},
                {15, 8, 15}};

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int wei = edge[2];

            adj.get(from).add(new Pair(to, wei));
        }

        List<Integer> list = func(n, m, adj);
        System.out.println(list);
    }

    private static List<Integer> func(int n, int m, ArrayList<ArrayList<Pair>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a1, a2) -> a1.dis - a2.dis);
        Pair1[] disPair = new Pair1[n + 1];

        for(int i = 0; i <= n; i++){
            disPair[i] = new Pair1(new ArrayList<>(), Integer.MAX_VALUE);
        }
        disPair[1].path.add(1);
        disPair[1].dis = 0;

        pq.add(new Pair( 1, 0));

        while(!pq.isEmpty()) {
            Pair out = pq.poll();
            int ver = out.ver;
            int disItTook = out.dis;
            for(Pair p: adj.get(ver)){
                int disChild = disItTook + p.dis;

                Pair1 pair = disPair[p.ver];
                if(disChild < pair.dis){
                    pair.dis = disChild;
                    pair.path = new ArrayList<>(disPair[ver].path);
                    pair.path.add(p.ver);

                    pq.add(new Pair(p.ver, disChild));
                }
            }
        }

        if (disPair[n].dis == Integer.MAX_VALUE) {
            return new ArrayList<>(List.of(-1));
        }

        // Build the result: first element is the weight, followed by the path
        List<Integer> result = new ArrayList<>();
        result.add(disPair[n].dis); // Add total weight
        result.addAll(disPair[n].path); // Add the path
        return result;
    }

    static class Pair1 {
        List<Integer> path;
        int dis;

        public Pair1(List<Integer> path, int dis) {
            this.path = path;
            this.dis = dis;
        }
    }
}
