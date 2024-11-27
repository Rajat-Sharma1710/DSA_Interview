package com.array.binarySearch;

public class InfiniteArrayBS {
    public static void main(String[] args) {
        /*
           Question that would arise is where do we place our end in case of
           an infinite array.
           * Solution to that is to place is beside start and while tar > arr[end]
             increase your end by end * 2 and place start to previous end.

             While(tar > arr[end]){
                st = end;
                end = end * 2;
             }
             as soon as tar comes in between start and end, apply simple Binary Search
             bs(arr, st, end);

         */
    }
}
