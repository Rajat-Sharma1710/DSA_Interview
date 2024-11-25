package com.array.binarySearch;

public class LastIndex {
    /*
        The key observation in here is that mid is shifted towards right
        in case of even elements
     */
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 7, 8, 8, 9};
        System.out.println(lastIndex(arr, arr.length));
    }

    private static int lastIndex(int[] nums, int n){
        if(nums.length == 0) return -1;
        int lo = 0, hi = n - 1;
        int mid;
        while(lo < hi){
            mid = (lo + hi + 1) / 2;
            if(nums[mid] <= 8){
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return (nums[hi] == 8) ? hi : -1;
    }
}
