package com.array.binarySearch;

public class FloorAndCeil {
    public static void main(String[] args) {
        int[] arr = {11, 12, 15, 18, 19, 22, 24};
        int k = 9;
        System.out.println("Floor is: " + findFloor(arr, k) + " and Ceil is: " + findCeil(arr, k));
    }

    private static int findCeil(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = n - 1;
        int mid;
        int ans = -1;
        while(l <= r){
            mid = (l + r) / 2;
            if(arr[mid] == k){
                return mid;
            } else if(arr[mid] < k){
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    private static int findFloor(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = n - 1;
        int mid;
        int ans = -1;
        while(l <= r){
            mid = (l + r) / 2;
            if(arr[mid] == k){
                return mid;
            } else if(arr[mid] < k){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
