package com.array.binarySearch;

public class searchInBitonicArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        int tar = 12;
        int ans = solve(arr, tar);
        System.out.println(ans);
    }

    public static int solve(int[] arr, int tar) {
        int n = arr.length;
        int peakIndx = findPeak(arr, n);
        // System.out.println("Peak Index is " + peakIndx);
        int indx1 = bs(arr, 0, peakIndx, tar, true);
        int indx2 = bs(arr, peakIndx + 1, n - 1, tar, false);
        // System.out.println("First Index is " + indx1);
        // System.out.println("Second Index is " + indx2);
        if(indx1 != -1) return indx1;
        else if(indx2 != -1) return indx2;
        else return -1;
    }

    private static int findPeak(int[] arr, int n){
        if(n == 1) return 0;
        int lo = 1, hi = n - 2;
        if(arr[0] > arr[1]) return 0;
        if(arr[n - 1] > arr[n - 2]) return n - 1;
        int mid;
        while(lo <= hi){
            mid = lo + ((hi - lo) / 2);
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            } else if(arr[mid] > arr[mid - 1]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    private static int bs(int[] arr, int st, int end, int tar, boolean flag){
        int mid;

        while(st <= end){
            mid = st + ((end - st) / 2);
            if(arr[mid] == tar) return mid;
            else if(arr[mid] < tar) {
                if(flag)
                    st = mid + 1;
                else
                    end = mid - 1;
            }
            else {
                if(flag)
                    end = mid - 1;
                else
                    st = mid + 1;
            }
        }
        return -1;
    }
}
