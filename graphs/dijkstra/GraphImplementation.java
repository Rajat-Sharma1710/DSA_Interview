package com.graphs.dijkstra;

import java.util.ArrayList;

public class GraphImplementation {

    /*

        0          3
              2 ------ 5
        1          4

     */
    public static ArrayList<ArrayList<Pair>> getDijkstraGraph() {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1, 4));
        adj.get(0).add(new Pair(2, 4));

        adj.get(1).add(new Pair(0, 4));
        adj.get(1).add(new Pair(2, 2));

        adj.get(2).add(new Pair(0, 4));
        adj.get(2).add(new Pair(1, 2));
        adj.get(2).add(new Pair(3, 3));
        adj.get(2).add(new Pair(5, 6));
        adj.get(2).add(new Pair(4, 1));

        adj.get(3).add(new Pair(2, 3));
        adj.get(3).add(new Pair(5, 2));

        adj.get(4).add(new Pair(2, 1));
        adj.get(4).add(new Pair(5, 3));

        adj.get(5).add(new Pair(2, 6));
        adj.get(5).add(new Pair(3, 2));
        adj.get(5).add(new Pair(4, 3));

        return adj;
    }

    public static ArrayList<ArrayList<Pair>> getDijkstraGraph_1() {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(4).add(new Pair(2, 4));
        adj.get(8).add(new Pair(11, 8));

        adj.get(6).add(new Pair(2, 6));
        adj.get(1).add(new Pair(11, 1));

        adj.get(6).add(new Pair(18, 6));
        adj.get(15).add(new Pair(16, 15));
        adj.get(2).add(new Pair(1, 2));
        adj.get(3).add(new Pair(6, 3));
        adj.get(11).add(new Pair(15, 11));

        adj.get(18).add(new Pair(11, 18));
        adj.get(15).add(new Pair(8, 15));

        return adj;
    }
}
class Pair {
    int ver, dis;

    public Pair(int ver, int dis){
        this.ver = ver;
        this.dis = dis;
    }
}
