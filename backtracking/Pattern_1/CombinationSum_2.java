package com.recursion.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Find all unique combinations of subsets
    each number may only be used once in the combination
 */
public class CombinationSum_2 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 1, 2};
        Set<List<Integer>> ans = new HashSet<>();
//        func(arr, new ArrayList<>(), 5, ans, 0);
        List<List<Integer>> res = new ArrayList<>();
        func_1(arr, new ArrayList<>(), 5, 0, 0, res);
//        System.out.println(ans.stream().toList());
        System.out.println(res);
    }

    private static void func(int[] arr, List<Integer> temp, int tar, Set<List<Integer>> ans, int indx){
        if(tar <= 0 || indx >= arr.length){
            if(tar == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(arr[indx]);
        func(arr, temp, tar-arr[indx], ans, indx+1);

        temp.remove(temp.size() - 1);
        func(arr, temp, tar, ans, indx+1);
    }

    private static void func_1(int[] arr, List<Integer> temp, int tar, int indx,
    int sumSoFar, List<List<Integer>> res){
        if(sumSoFar >= tar || indx == arr.length) {
            if(sumSoFar == tar) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(arr[indx]);
        func_1(arr, temp, tar, indx + 1, sumSoFar + arr[indx], res);
        temp.remove(temp.size() - 1);
        func_1(arr, temp, tar, indx + 1, sumSoFar, res);
    }
}
