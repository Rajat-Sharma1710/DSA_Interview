package com.graphs.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static com.graphs.dijkstra.ShortestPathInBinaryMaze.xAxis;
import static com.graphs.dijkstra.ShortestPathInBinaryMaze.yAxis;

public class PathWithMinEffort {
    public static void main(String[] args) {
        int[][] heights = {{1, 3, 5, 1}, {1, 1, 4, 3}};
        int ans = minEffort(heights);
        System.out.println(ans);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        pq.add(new int[]{1, 2});
    }

    private static int minEffort(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((o1, o2) -> o1.dis - o2.dis);
        int[][] dis = new int[n][m];
        // O(n * m)
        for(int i = 0; i < n; i++) {
            Arrays.fill(dis[i], (int) 1e9);
        }
        dis[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        while(!pq.isEmpty()) {
            Tuple out = pq.poll();
            int d = out.dis, r = out.xCoor, c = out.yCoor;

            if(dis[r][c] < d) {
                continue;
            }
            // Check for destination while taking out of the PQ, not while inserting...
            if(r == n - 1 && c == m - 1) return dis[r][c];
            for(int i = 0; i < 4; i++) {
                int newR = r + xAxis[i];
                int newC = c + yAxis[i];

                if(newR >= 0 && newR < n && newC >= 0 && newC < m) {
                    int currentEffort = Math.abs(heights[newR][newC] - heights[r][c]);
                    int newEffort = Math.max(d, currentEffort);

                    if (newEffort < dis[newR][newC]) {
                        dis[newR][newC] = newEffort;
                        pq.add(new Tuple(newEffort, newR, newC));
                    }
                }
            }
        }
        return -1;
    }
}
