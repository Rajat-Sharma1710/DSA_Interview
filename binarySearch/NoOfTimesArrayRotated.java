package com.array.binarySearch;

public class NoOfTimesArrayRotated {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int ans = func(arr, arr.length);
        System.out.println(ans);
    }

    private static int func(int[] a, int len){
        int lo = 0, hi = len - 1;
        int mid;
        while(lo <= hi){
            mid = (lo + hi) / 2;
            if(a[mid] <= a[(mid + 1) % len] && a[mid] <= a[(mid - 1 + len) % len]){
                return a[mid];
            } else if(a[lo] <= a[mid] && a[mid] <= a[hi]){
                hi = mid - 1;
            } else if(a[mid] >= a[lo]){
                lo = mid + 1;
            } else if(a[mid] <= a[hi]){
                hi = mid - 1;
            }
        }
        return -1;
    }
}
