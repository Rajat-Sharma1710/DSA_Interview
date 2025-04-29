package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphsImpl {

    public static List<List<Integer>> normalShape() {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(1);
        graph.get(2).add(5);

        graph.get(3).add(1);
        graph.get(3).add(4);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(2);
        graph.get(5).add(4);
        return graph;
    }

    /*
                 1
           2           3
         3   4      7     9
             5  -   8
     */
    public static List<List<Integer>> treeShape() {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= 9; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(6);

        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(2).add(1);

        graph.get(3).add(2);

        graph.get(6).add(7);
        graph.get(6).add(9);
        graph.get(6).add(1);

        graph.get(4).add(5);
        graph.get(4).add(2);

        graph.get(7).add(8);
        graph.get(7).add(6);

        graph.get(5).add(8);
        graph.get(5).add(4);

        graph.get(8).add(7);
        graph.get(8).add(5);

        graph.get(9).add(6);
        return graph;
    }

    /*
             2 - 5
         1           7
             3 - 6
             4
     */
    public static List<List<Integer>> cyclicGraph() {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= 7; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);

        graph.get(2).add(5);
        graph.get(2).add(1);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(6);

        graph.get(4).add(3);

        graph.get(5).add(7);
        graph.get(5).add(2);

        graph.get(6).add(3);
        graph.get(6).add(7);


        graph.get(7).add(5);
        graph.get(7).add(6);
        return graph;
    }

    /*
         1 - 2 - 3 - 4
     */
    public static List<List<Integer>> simpleLineGraph() {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= 4; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);

        graph.get(2).add(3);
        graph.get(2).add(1);

        graph.get(3).add(4);
        graph.get(3).add(2);

        graph.get(4).add(3);
        return graph;
    }

    /*
        1 - 2 - 3
            5 - 4
     */
    public static List<List<Integer>> anotherCyclic() {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= 5; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);

        graph.get(2).add(3);
        graph.get(2).add(1);
        graph.get(2).add(5);

        graph.get(3).add(4);
        graph.get(3).add(2);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(4);
        graph.get(5).add(2);
        return graph;
    }

    public static List<List<Integer>> cyclicNoBipartite() {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);

        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(5);

        graph.get(3).add(2);
        graph.get(3).add(4);

        graph.get(4).add(3);
        graph.get(4).add(6);
        graph.get(4).add(7);

        graph.get(5).add(2);
        graph.get(5).add(6);

        graph.get(6).add(4);
        graph.get(6).add(5);

        graph.get(7).add(4);
        graph.get(7).add(8);

        graph.get(8).add(7);
        return graph;
    }

    public static List<List<Integer>> cyclicBipartite() {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= 7; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);

        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(4);

        graph.get(3).add(2);
        graph.get(3).add(5);
        graph.get(3).add(6);

        graph.get(4).add(2);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(3);
        graph.get(6).add(7);

        graph.get(7).add(6);
        return graph;
    }

    /*
        Here in MST we only define a particular edge once and not vice-versa / twice
        even it is an undirected graph
     */
    public static ArrayList<ArrayList<Pair1>> getPrimsGraph() {
        ArrayList<ArrayList<Pair1>> adj = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair1(3, 6));
        adj.get(0).add(new Pair1(1, 2));
        adj.get(1).add(new Pair1(2, 3));
        adj.get(1).add(new Pair1(3, 8));
        adj.get(1).add(new Pair1(4, 5));
        adj.get(2).add(new Pair1(4, 7));

        return adj;
    }
}

class Pair1 {
    int node, wei;
    public Pair1(int node, int wei) {
        this.node = node;
        this.wei = wei;
    }
}
