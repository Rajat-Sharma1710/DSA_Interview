package com.backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    TC -> n! * O(n) for the loop
    SC -> o(n) for ds + O(n) for flag boolean
 */
public class PrintPermutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> ds = new ArrayList<>();
//        boolean[] flag = new boolean[nums.length];
//        func(nums, res, ds, flag);
        func_1_less_space(nums, 0, res);
        System.out.println(res);
    }

    /*
        1 -> 1, 2 -> 1, 2, 3 -> return -> remove 3, made false -> call with i = 3 again
        for loop exceeded -> return -> remove 2, made false -> i = 1 -> inside for loop
        with i = 2 -> this time add 3 so ds now becomes -> 1, 3 -> 1, 3, 2....
     */
    private static void func(int[] nums, List<List<Integer>> res, List<Integer> ds, boolean[] flag) {
        if(ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                ds.add(nums[i]);

                func(nums, res, ds, flag);

                ds.remove(ds.size() - 1);
                flag[i] = false;
            }
        }
    }

    private static void func_1_less_space(int[] nums, int indx, List<List<Integer>> res) {
        if(indx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int ele: nums) {
                ds.add(ele);
            }
            res.add(ds);
            return;
        }
        for(int i = indx; i < nums.length; i++) {
            swap(nums, indx, i);
            func_1_less_space(nums, indx + 1, res);
            swap(nums, indx, i);
        }
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
