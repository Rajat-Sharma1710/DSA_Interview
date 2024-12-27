package com.array.binarySearch;

public class MedianMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 10}, {2, 10, 11}, {3, 10, 11}};
        int ans = median(matrix);
        System.out.println(ans);
    }

    private static int median(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        int medianIndx = (n*m) / 2;
        int lo = 1, hi = 2000;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int ele = 0;
            for(int[] arr: mat){
                ele += elementsLesserEqualToMid(arr, mid);
            }
            if(ele <= medianIndx){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static int elementsLesserEqualToMid(int[] arr, int tar) {
        int n = arr.length;
        int lo = 0, hi = n - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] <= tar){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
