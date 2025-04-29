package com.graphs.directed;

import java.util.ArrayList;

public class DirectedGraphsImpl {

    /*
        6 -> 3    2
        v v  ^    ^
        5    7 -> 1
        n = 8 means vertex from 0 to 7
     */
    public static ArrayList<ArrayList<Integer>> topo1() {
        ArrayList<ArrayList<Integer>> directedGraph = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            directedGraph.add(new ArrayList<>());
        }

        directedGraph.get(6).add(3);
        directedGraph.get(7).add(3);
        directedGraph.get(6).add(5);
        directedGraph.get(3).add(5);
        directedGraph.get(7).add(1);
        directedGraph.get(1).add(2);
        return directedGraph;
    }

    /*
        6 -> 3    2
        v ^\  v    ^
        5    7 -> 1
        n = 8 means vertex from 0 to 7
     */
    public static ArrayList<ArrayList<Integer>> topo1_cycle() {
        ArrayList<ArrayList<Integer>> directedGraph = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            directedGraph.add(new ArrayList<>());
        }

        directedGraph.get(6).add(3);
        directedGraph.get(7).add(6);
        directedGraph.get(6).add(5);
        directedGraph.get(3).add(7);
        directedGraph.get(7).add(1);
        directedGraph.get(1).add(2);
        return directedGraph;
    }

    /*
        5 -> 0 <- 4
        v         v
        2 -> 3 -> 1
     */
    public static ArrayList<ArrayList<Integer>> topo2() {
        ArrayList<ArrayList<Integer>> directedGraph = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            directedGraph.add(new ArrayList<>());
        }

        directedGraph.get(5).add(0);
        directedGraph.get(5).add(2);
        directedGraph.get(2).add(3);
        directedGraph.get(3).add(1);
        directedGraph.get(4).add(1);
        directedGraph.get(4).add(0);
        return directedGraph;
    }
}
