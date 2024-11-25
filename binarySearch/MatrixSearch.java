package com.array.binarySearch;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] arr = {{1}};
        boolean ans = bs(arr, 3);
        System.out.println(ans);
    }

    private static boolean bs(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        while(row < n && matrix[row][m - 1] < target){
            row++;
        }
        if(row == n){
            return false;
        }

        return func(matrix, row, target);
    }

    private static boolean func(int[][] matrix, int row, int target){
        int m = matrix[0].length;
        int st = 0;
        int end = m - 1;
        int mid;
        while(st <= end){
            mid = end - ((end - st) / 2);

            if(matrix[row][mid] == target){
                return true;
            } else if(matrix[row][mid] > target){
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return false;
    }
}
