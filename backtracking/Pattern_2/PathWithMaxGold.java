package com.backtracking.leetcode;

public class PathWithMaxGold {
    static int[] x = {0, -1, 0, 1};
    static int[] y = {-1, 0, 1, 0};
    static int max = 0;
    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    dfs(grid,i,j,0,m,n);
                }
            }
        }
        System.out.println(max);
    }

    /*
        Approach 1, we change the sum in the current frame that's why we
        need to undo to its previous value after recursive call
     */
    private void getGold(int[][] grid, int i, int j, boolean[][] vis, int sum) {
        max = Math.max(max, sum);
        for(int k = 0; k < 4; k++) {
            int newX = i + x[k];
            int newY = j + y[k];
            if(isValid(grid, newX, newY, vis)) {
                vis[newX][newY] = true;
                sum += grid[newX][newY];
                getGold(grid, newX, newY, vis, sum);
                vis[newX][newY] = false;
                sum -= grid[newX][newY];
            }
        }
    }

    private boolean isValid(int[][] grid, int x, int y, boolean[][] vis) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] == 0 || vis[x][y]) return false;
        return true;
    }

    /*
        Approach 2,  don't need to reduce sum after recursive call, as we change
        the local copy and pass it in next recursive call

    */
    private static void dfs(int[][] grid, int i, int j, int sum, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
            return ;
        }
        int curr=grid[i][j];
        sum+=grid[i][j];
        max=Math.max(max,sum);
        grid[i][j]=0;

        dfs(grid,i-1,j,sum,m,n);
        dfs(grid,i+1,j,sum,m,n);
        dfs(grid,i,j-1,sum,m,n);
        dfs(grid,i,j+1,sum,m,n);
        grid[i][j]=curr;
    }
}
