package com.array.binarySearch;

/*

 */
public class MedianSearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {3, 7, 9}, {11, 12, 13}};
        int ans = findMedian(matrix);
        System.out.println(ans);
    }

    private static int findMedian(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int total = n * m;
        int lo = 1, hi = matrix[n-1][m-1];
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(smallestThanTarget(matrix, mid) <= total/2){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static int smallestThanTarget(int[][] matrix, int ele){
        int n = matrix.length;
        int m = matrix[0].length;
        int cnt = 0;
        for(int[] arr: matrix){
            int size = arr.length;
            int lo = 0, hi = size - 1;

            while(lo <= hi){
                int mid = (lo + hi) / 2;
                if(arr[mid] <= ele){
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            cnt += lo;
        }
        return cnt;
    }
}
