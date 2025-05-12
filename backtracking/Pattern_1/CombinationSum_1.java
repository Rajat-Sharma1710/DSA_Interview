package com.recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Find all unique combinations of subsets
    same number can be used multiple times
 */
public class CombinationSum_1 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> ans = new ArrayList<>();
        func(arr, 0, 7, 0, new ArrayList<>(), ans);

        System.out.println(ans);
    }

    private static void func(int[] arr, int indx, int tar, int sumSoFar,
                      List<Integer> temp, List<List<Integer>> res) {
        if(sumSoFar >= tar || indx == arr.length) {
            if(sumSoFar == tar) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(arr[indx]);
        func(arr, indx, tar, sumSoFar + arr[indx], temp, res);
        temp.remove(temp.size() - 1);
        func(arr, indx + 1, tar, sumSoFar, temp, res);
    }

    private static void func2(int[] arr, int indx, int tar, int sumSoFar,
                             List<Integer> temp, List<List<Integer>> res) {
        if(sumSoFar == tar) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = indx; i < arr.length; i++) {
            if(sumSoFar < tar) {
                temp.add(arr[i]);
                func2(arr, i, tar, sumSoFar + arr[i], temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
