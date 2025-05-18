package com.backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = new ArrayList<>();
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(arr[i], '.');
        }
        int[] colIndx = new int[n];
        int[] upperRightDiag = new int[(2*n) - 1];
        int[] upperLeftDiag = new int[(2*n) - 1];
        func(n , arr, 0, colIndx, upperRightDiag, upperLeftDiag, ans);

        System.out.println(ans);
    }

    private static void func(int n, char[][] arr, int row,
                             int[] colIndx, int[] upperRightDiag,
                             int[] upperLeftDiag, List<List<String>> ans){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(new String(arr[i]));
            }
            ans.add(list);
        }
        for(int i = 0; i < n; i++){
            if(colIndx[i] == 0 && upperRightDiag[row + i] == 0 &&
                    upperLeftDiag[(n - 1) + (i - row)] == 0) {
//                bool[row][i] = true;
                arr[row][i] = 'Q';
                colIndx[i] = 1;
                upperRightDiag[row + i] = 1;
                upperLeftDiag[(n - 1) + (i - row)] = 1;
                func(n, arr, row + 1, colIndx, upperRightDiag, upperLeftDiag, ans);
//                bool[row][i] = false;
                arr[row][i] = '.';
                colIndx[i] = 0;
                upperRightDiag[row + i] = 0;
                upperLeftDiag[(n - 1) + (i - row)] = 0;
            }
        }
    }
}
