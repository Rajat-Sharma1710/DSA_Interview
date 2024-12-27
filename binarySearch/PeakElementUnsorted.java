package com.array.binarySearch;

public class PeakElementUnsorted {
    public static void main(String[] args) {
        // Array might contains multiple peak elements, return any of the peak index
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        int indx = findPeak(arr, arr.length);
        System.out.println(indx);
    }

    /*
        The idea would be see if the element is greater from both sides and return,
        Otherwise, if the element is greater than its previous then it is increasing
        hence the peak would be on the right...
        Otherwise, if the element is lesser than its previous then it is decreasing
        hence the peak would be on the left..
     */
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
}
