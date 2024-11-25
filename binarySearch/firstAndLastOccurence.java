package com.array.binarySearch;

public class firstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,4,5,5,5,5,6,8,9};
        int first = firstOcc(arr, arr.length, 9);
        int last = lastOcc(arr, arr.length, 9);

        System.out.println("First Occurence of ele is " + first + " and Last Occurence of ele is " + last);
    }

    private static int firstOcc(int[] arr, int len, int ele){
        int l = 0, r = len - 1;
        int mid;
        int ans = -1;
        while(l <= r){
            mid = (l + ((r - l) / 2));
            if(arr[mid] == ele){
                ans = mid;
                r = mid - 1;
            } else if(arr[mid] < ele){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private static int lastOcc(int[] arr, int len, int ele){
        int l = 0, r = len - 1;
        int mid;
        int ans = -1;
        while(l <= r){
            mid = (l + ((r - l) / 2));
            if(arr[mid] == ele){
                ans = mid;
                l = mid + 1;
            } else if(arr[mid] < ele){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
