package com.graphs.dijkstra;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMaze {
    static int[] xAxis = {0, -1, 0, 1};
    static int[] yAxis = {-1, 0, 1, 0};
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
        {1, 1, 0, 1},
        {1, 1, 1, 1},
        {1, 1, 0, 0},
        {1, 0, 0, 1}};

        int[] source = {0, 1}, destination = {2, 2};
        int dis = shortestDis(grid, source, destination);
        System.out.println(dis);
    }

    private static int shortestDis(int[][] grid, int[] source, int[] des) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dis = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dis[i][j] = (int)(1e9);
            }
        }
        Queue<Tuple> que = new LinkedList<>();
        que.add(new Tuple(0, source[0], source[1]));
        dis[source[0]][source[1]] = 0;

        while(!que.isEmpty()) {
            Tuple out = que.poll();
            int x = out.xCoor;
            int y = out.yCoor;

            for(int i = 0; i < 4; i++) {
                int newX = x + xAxis[i];
                int newY = y + yAxis[i];


                if(isValid(grid, newX, newY)){
                    que.add(new Tuple(out.dis + 1, newX, newY));
                    dis[newX][newY] = out.dis + 1;
                }

                if(newX == des[0] && newY == des[1]){
                    return dis[newX][newY];
                }
            }
        }
        return dis[des[0]][des[1]];
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 0;
    }

}
class Tuple {
    int dis, xCoor, yCoor;

    public Tuple(int dis, int xCoor, int yCoor) {
        this.dis = dis;
        this.xCoor = xCoor;
        this.yCoor = yCoor;
    }
}
