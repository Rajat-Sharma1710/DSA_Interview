package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static com.graphs.directed.DirectedGraphsImpl.topo1;
import static com.graphs.directed.DirectedGraphsImpl.topo1_cycle;

// We actually don't need vis array here, Just call sequence 1 time, it'll cover all vertices
// Think about this....
public class KahnsAlgorithm {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = topo1_cycle();
        System.out.println(adj);

        int[] inOrder = new int[adj.size()];
        for(int i = 0; i < adj.size(); i++){
            for(int ele: adj.get(i)){
                inOrder[ele]++;
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        for(int i = 0; i < adj.size(); i++){
            if(!vis[i]) {
                sequence(adj, i, inOrder, topo, vis);
            }
        }

        System.out.println(topo);
    }

    private static void sequence(ArrayList<ArrayList<Integer>> adj, int vertex, int[] inOrder, ArrayList<Integer> topo,
    boolean[] vis) {

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < inOrder.length; i++){
            if(inOrder[i] == 0 && !vis[i]){
                vis[i] = true;
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int out = que.poll();

            for(int ele: adj.get(out)){
                inOrder[ele]--;

                if(inOrder[ele] == 0 && !vis[ele]){
                    vis[ele] = true;
                    que.add(ele);
                }
            }

            topo.add(out);
        }
    }
}
