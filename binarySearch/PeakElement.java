package com.array.binarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(func(arr));
    }

    private static int func(int[] nums){
        int n = nums.length;
        int lo = 0, hi = n - 1;

        int mid;
        while(lo <= hi){
            mid = (lo + hi) / 2;
            if(mid == 0 && nums[mid] > nums[mid + 1]){
                return mid;
            } else if(mid == n - 1 && nums[mid] > nums[mid - 1]){
                return mid;
            } else if(mid > 0 && mid < n-1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            } else if(mid < n - 1 && nums[mid] < nums[mid + 1]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
