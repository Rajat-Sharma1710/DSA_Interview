package com.array.binarySearch;

public class IncreasingDecreasingMax {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 10, 11};
        System.out.println(func1(arr, arr.length));
    }

    private static int func(int[] arr, int n){
        int mid;
        int l = 0, r = n - 1;
        while(l <= r){
            mid = (l + r) / 2;

            if(mid == 0){
                if(arr[mid] > arr[mid + 1]){
                    // edge case
                    return Math.max(arr[mid], arr[n - 1]);
                } else {
                    l = mid + 1;
                }
            }
            if(mid == n - 1){
                if(arr[mid] > arr[mid - 1]){
                    //edge case
                    return Math.max(arr[mid], arr[0]);
                } else {
                    r = mid - 1;
                }
            }

            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return arr[mid];
            }
            if(arr[mid] < arr[mid + 1]){
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }
        return -1;
    }

    private static int func1(int[] arr, int n){
        int mid;
        int l = 0, r = n - 1;
        while(l <= r){
            mid = (l + r) / 2;

            if(mid == 0){
                return Math.max(arr[mid], arr[mid + 1]);
            }else if(mid == n - 1){
                return arr[mid];
            }else if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return arr[mid];
            }

            if(arr[mid] < arr[mid + 1]){
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }
        return -1;
    }
}
