package com.graphs.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlight {
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};

        int cost = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cost);
    }

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m = flights.length;

        int[] dis = new int[n];
        Arrays.fill(dis, (int)1e9);

        // {stops, node, cost}
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] data: flights) {
            adj.get(data[0]).add(new int[]{data[1], data[2]});
        }
        dis[src] = 0;
        pq.add(new int[]{0, src, 0});

        while(!pq.isEmpty()) {
            int[] out = pq.poll();
            int srcNode = out[1];
            int stops = out[0];
            int cost  = out[2];
            if(stops > k) break;
            for(int[] arr: adj.get(srcNode)) {
                int des = arr[0];
                int currCost = arr[1];

                if(dis[des] > cost + currCost && stops <= k) {
                    dis[des] = cost + currCost;
                    pq.add(new int[]{stops + 1, des, cost + currCost});
                }
            }
        }
        return (dis[dst] == (1e9)) ? -1 : dis[dst];
    }
}
