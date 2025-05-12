package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesAgain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        printSub(arr, list, res, 0, 5);
//        int cnt = countSubsequences(arr, 0, 5);
        System.out.println(res);
    }

    private static void printSub(int[] arr, List<Integer> list, List<List<Integer>> res, int indx
    ,int k) {
        if(indx == arr.length) {
            if(k == 0)
                res.add(new ArrayList<>(list));
            return;
        }

        printSub(arr, list, res, indx + 1, k);
//        list = new ArrayList<>();
        list.add(arr[indx]);

        printSub(arr, list, res, indx + 1, k - arr[indx]);
        list.remove(list.size() - 1);
    }

    private static int countSubsequences(int[] arr, int indx, int k) {
        if(indx == arr.length) {
            if(k == 0){
                return 1;
            } else {
                return 0;
            }
        }
        int left = countSubsequences(arr, indx + 1, k);

        int right = countSubsequences(arr, indx + 1, k - arr[indx]);
        return left + right;
    }
}
