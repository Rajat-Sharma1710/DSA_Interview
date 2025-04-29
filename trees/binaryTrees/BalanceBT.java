package com.trees.binaryTrees;

public class BalanceBT {
    static boolean ans = false;
    public static void main(String[] args) {
        Node root = Node.implementation5();
        int ans = isBalanced(root);
        System.out.println(ans == -1 ? "False" : "True");
    }

    private static int isBalanced(Node root) {
        if(root == null){
            return 0;
        }
        int left = isBalanced(root.left);
        if(left == -1) return -1;
        int right = isBalanced(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
