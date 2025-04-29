package com.graphs.dijkstra;

import java.util.*;

import static com.graphs.dijkstra.GraphImplementation.getDijkstraGraph;
import static com.graphs.dijkstra.GraphImplementation.getDijkstraGraph_1;

public class DijkstraPQ {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> adj = getDijkstraGraph_1();

        int src = 1;

        int[] shorDis = getShortestDis(adj, src);
        for(int ele: shorDis) {
            System.out.print(ele + " ");
        }
    }

    private static int[] getShortestDis(ArrayList<ArrayList<Pair>> adj, int src) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.dis - p2.dis);
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
