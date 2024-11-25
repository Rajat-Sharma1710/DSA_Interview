package com.array.binarySearch;

public class everyElementOccursTwiceExceptOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(func(arr, arr.length));
    }

    private static int func(int[] arr, int n){
        int mid;
        int left = 0;
        int right = n-1;

        while(left <= right){
            mid = (left + right) / 2;


            if(mid == 0 || mid == n - 1){
                return arr[mid];
            }
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid + 1]){
                return arr[mid];
            }
            /*
                The only way to go left and right is by observing indexes
                means, if we observe the first occurence of every element
                lies on even indexes 0,2,4 etc and occurence of odd index lies
                on odd indexes 1,3,5.
                But this condition changes after the occurence of unique element
                and due to which we have to check, while the above 2 conditions satisfy
                we need to go right to find the unique element
            */
            boolean firstOcc = (arr[mid] != arr[mid - 1]);
            if((firstOcc && mid % 2 == 0) || (!firstOcc && mid % 2 == 1)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
