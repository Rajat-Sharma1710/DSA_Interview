package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequences {

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int arr[] = {1, 2, 3};
        List<Integer> temp = new ArrayList<>();
        subset(arr, 0, temp, ans);
//        for(List<Integer> list: ans){
//            System.out.println(list);
//        }
    }

    private static void subset(int[] arr, int st, List<Integer> temp, List<List<Integer>> ans) {
        if(st == arr.length){
            System.out.println(temp);
            return;
        }
        subset(arr, st + 1, temp, ans);

        temp.add(arr[st]);
        subset(arr, st + 1, temp, ans);

        temp.remove(temp.size() - 1);

    }
}
