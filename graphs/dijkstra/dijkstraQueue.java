package com.graphs.dijkstra;

import java.util.*;

import static com.graphs.dijkstra.GraphImplementation.getDijkstraGraph;

/*
    We can solve this using simple Queue but here the number of
    iterations would be more coz we are taking out the pair which
    comes first, now it would be the one with larger distance or smaller one
    so, we would need to cover all edges iteration for that vertex
 */
public class dijkstraQueue {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> adj = getDijkstraGraph();

        int src = 0;

        int[] shorDis = getShortestDis(adj, src);
        for(int ele: shorDis) {
            System.out.print(ele + " ");
        }
    }

    private static int[] getShortestDis(ArrayList<ArrayList<Pair>> adj, int src) {

        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src, 0));
        int[] dis = new int[adj.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        while(!pq.isEmpty()){
            Pair out = pq.poll();
            if(dis[out.ver] < out.dis) continue;
            int disItTook = out.dis;
            int ver = out.ver;

            for(Pair adjPair: adj.get(ver)) {
                int disForCurrVer = adjPair.dis + disItTook;
                if(disForCurrVer < dis[adjPair.ver]){
                    dis[adjPair.ver] =  disForCurrVer;
                    pq.add(new Pair(adjPair.ver, disForCurrVer));
                }
            }
        }

        return dis;
    }
}
