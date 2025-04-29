package com.graphs.dijkstra;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},
                {6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int n = 7;
        int ans = countPaths(n, roads);
        System.out.println(ans);
    }

    private static int countPaths(int n, int[][] roads) {
        int m = roads.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int from = roads[i][0];
            int to = roads[i][1];
            int time = roads[i][2];
            adj.get(from).add(new int[]{to, time});
            adj.get(to).add(new int[]{from, time});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            if(a1[0] == a2[0]) return a1[1] - a2[1];
            else return a1[0] - a2[0];
        });
        pq.add(new int[]{0, 0});
        int[] time = new int[n];
        Arrays.fill(time, (int)1e9);
        time[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(!pq.isEmpty()) {
            int[] out = pq.poll();

            for(int[] arr: adj.get(out[1])) {
                int node = arr[0];
                int currTime = arr[1];
                int newTime = time[out[1]] + currTime;
                if(newTime < time[node]) {
                    time[node] = newTime;
                    pq.add(new int[]{newTime, node});
                    // if this is intersection n - 1
                    if(node == n - 1) {
                        map.put(newTime, 1);
                    }
                } else if(newTime == time[node] && node == n - 1 && map.containsKey(newTime)) {
                    map.put(newTime, map.get(newTime) + 1);
                }
            }
        }

        return map.get(time[n - 1]);
    }
}
