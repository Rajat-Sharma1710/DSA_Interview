package com.graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}};
        int cnt = countDistinctIslands(grid);
        System.out.println(cnt);
    }

    static int[] x = {0, -1, 0, 1};
    static int[] y = {-1, 0, 1, 0};
    private static int countDistinctIslands(int[][] grid) {
        // Your Code here
        int row = grid.length;
        int col = grid[0].length;
        boolean vis[][] = new boolean[row][col];

        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    ArrayList<String> list = new ArrayList<>();
                    vis[i][j] = true;
                    dfs(grid, i, j, vis, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private static void dfs(int[][] grid, int row, int col, boolean[][] vis,
             ArrayList<String> list, int baseRow, int baseCol){

        for(int i = 0; i < 4; i++){
            int newRow = row + x[i];
            int newCol = col + y[i];
            if(isSafe(grid, newRow, newCol, vis)){
                vis[newRow][newCol] = true;
                list.add(toString(newRow - baseRow, newCol - baseCol));
                // remember this VIMP always pass same initial baseRow, baseCol till
                // the entire single dfs cycle
                dfs(grid, newRow, newCol, vis, list, baseRow, baseCol);
            }
        }
    }

    private static String toString(int row, int col){
        return Integer.toString(row) + ", " + Integer.toString(col);
    }

    private static boolean isSafe(int[][] grid, int r, int c, boolean[][] vis){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                || vis[r][c] || grid[r][c] == 0) return false;
        return true;
    }
}
