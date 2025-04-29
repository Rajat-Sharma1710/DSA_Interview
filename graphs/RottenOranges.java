package com.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int time = timeToRottenOranges(grid);
        System.out.println(time);
    }

    private static int timeToRottenOranges(int[][] grid) {
        int[] xAxis = {-1, 0, 0, 1};
        int[] yAxis = {0, -1, 1, 0};
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> que = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    que.add(new Pair(i, j, 0));
                }
            }
        }
        int ans = 0;
        while(!que.isEmpty()) {
            Pair p = que.poll();
            ans = p.time;
            for(int i = 0; i < 4; i++){
                int newX = p.x + xAxis[i];
                int newY = p.y + yAxis[i];
                if(isValid(grid, newX, newY)){
                    grid[newX][newY] = 2;
                    que.add(new Pair(p.x + xAxis[i], p.y + yAxis[i], p.time + 1));
                }
            }
        }
        return ans;
    }

    private static boolean isValid(int[][] grid, int x, int y){
        return (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                && grid[x][y] == 1);
    }
}

class Pair{
    int x, y, time;

    public Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
