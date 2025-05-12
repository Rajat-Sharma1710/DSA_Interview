package com.recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        // [], [3], [1], [4], [3, 1], [3, 4], [1, 4], [3, 1, 4]
        subsetSums(arr, list, 0, 0, new ArrayList<>());
        System.out.println(list);
    }

    private static void subsetSums(int[] arr, List<Integer> res, int indx,
                                   int sumSoFar, List<Integer> temp) {
        if(indx == arr.length) {
            res.add(sumSoFar);
            return;
        }
         subsetSums(arr, res, indx + 1, sumSoFar, temp);
         subsetSums(arr, res, indx + 1, sumSoFar + arr[indx], temp);
    }
}
