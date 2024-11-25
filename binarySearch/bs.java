package com.array.binarySearch;

public class bs {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6};
        System.out.println(func(arr, 0, arr.length - 1, 4));
    }

    private static int func(int[] arr, int l, int r, int tar){
        if(l > r){
            return -1;
        }
        int mid = (r + l) / 2;

        if(tar < arr[mid]){
            return func(arr, l, mid - 1, tar);
        } else if(tar > arr[mid]){
            return func(arr, mid + 1, r, tar);
        } else {
            return mid;
        }
    }
}
