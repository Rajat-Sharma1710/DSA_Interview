package com.graphs.directed;

import java.util.ArrayList;

import static com.graphs.directed.DirectedGraphsImpl.topo1_cycle;

public class CycleDetectionDirected_BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = topo1_cycle();
        System.out.println(adj);
    }
}
