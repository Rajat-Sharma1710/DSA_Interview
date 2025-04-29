package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0}};
        int cnt = numberOfEnclaves(grid);
        System.out.println(cnt);
    }

    private static int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1){
                    if(grid[i][j] == 1){
                        vis[i][j] = 1;
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }

        int[] x = {0, -1, 0, 1};
        int[] y = {-1, 0, 1, 0};

        while(!queue.isEmpty()){
            int[] ar = queue.poll();
            for(int i = 0; i < 4; i++){
                int newX = ar[0] + x[i];
                int newY = ar[1] + y[i];
                if(newX >= 0 && newY >= 0 && newX < n && newY < m
                        && grid[newX][newY] == 1 && vis[newX][newY] == 0){
                    vis[newX][newY] = 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
