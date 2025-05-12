package com.recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

public class subsetSum2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = new ArrayList<>();
        func(arr, 0, new ArrayList<>(), ans, false);

        System.out.println(ans);
    }

    private static void func(int[] arr, int indx, List<Integer> temp, List<List<Integer
            >> ans, boolean choosePre){
        if(indx >= arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(indx >0 && arr[indx] == arr[indx - 1] && !choosePre) return;

        temp.add(arr[indx]);
        func(arr, indx + 1, temp, ans, true);
        temp.remove(temp.size() - 1);
        func(arr, indx + 1, temp, ans, false);
    }
}
