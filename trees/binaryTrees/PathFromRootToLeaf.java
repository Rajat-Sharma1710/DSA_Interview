package com.trees.binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PathFromRootToLeaf {
    static List<List<Integer>> ans;
    static List<String> ans_1;
    public static void main(String[] args) {
        Node root = Node.implementation3();
        int lo = 150, hi = 250;
        ans = new ArrayList<>();
        rootToLeaf(root, lo, hi, 0, new ArrayList<>());
        System.out.println(ans);

        ans_1 = new ArrayList<>();
        rootToLeaf_1(root, lo, hi, 0, "");
        System.out.println(ans_1);
    }

    /*
        Here Since String is immutable, initially the s variable created in stack will point
        to the same string object i.e. "", but as soon as line 33 executes each time a new
        String gets created and the same variable s will point to the new string, which is why
        we don't need to remove anything from the string
     */
    private static void rootToLeaf_1(Node root, int lo, int hi, int sum, String s) {
        if(root == null){
            return;
        }
        sum += root.val;
        s += root.val + ", ";
        if(root.left == null && root.right == null){
            if(sum >= lo && sum <= hi){
            }
            ans_1.add("[" + s + "]");
            return;
        }
        rootToLeaf_1(root.left, lo, hi, sum, s);
//        pathList.remove(pathList.size() - 1);
        rootToLeaf_1(root.right, lo, hi, sum, s);
//        pathList.remove(pathList.size() - 1);
    }

    /* because we are storing the path right from start to end in a List<Integer>, the original
       list has been changed every time and hence we need to revert the changes made during last
       recursive call, hence line 36 and 38, we need to delete the last element
     */
    private static void rootToLeaf(Node root, int lo, int hi, int sum, List<Integer> pathList) {
        if(root == null){
            return;
        }
        sum += root.val;
        pathList.add(root.val);
        if(root.left == null && root.right == null){
            if(sum >= lo && sum <= hi){
                ans.add(new ArrayList<>(pathList));
            }
            return;
        }
        rootToLeaf(root.left, lo, hi, sum, pathList);
        pathList.remove(pathList.size() - 1);
        rootToLeaf(root.right, lo, hi, sum, pathList);
        pathList.remove(pathList.size() - 1);
    }
}
