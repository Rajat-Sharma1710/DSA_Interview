package com.trees.binarySearchTrees;

import static com.trees.binarySearchTrees.Node.construct_2;

public class validateBST {
    public static void main(String[] args) {
        Node root = construct_2();

        boolean ans = isValidBST(root);
        System.out.println(ans);
    }

    private static boolean isValidBST(Node root) {
        return isValid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(Node root, Long min, Long max) {
        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max) return false;
        return isValid(root.left, min, (long) root.val) &&
                isValid(root.right, (long) root.val, max);
    }
}
