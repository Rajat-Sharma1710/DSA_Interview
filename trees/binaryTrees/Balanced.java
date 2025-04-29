package com.trees.binaryTrees;

public class Balanced {
    public static void main(String[] args) {
        Node root = Node.implementation10();
        int ans = func(root, 1);
        System.out.println(ans);
    }

    private static int func(Node root, int hei) {
        if(root == null) {
            return 0;
        }
        int left = func(root.left, hei);
        int right = func(root.right, hei);

        if(left == 0 || right == 0) return 0;

        return Math.max(left, right) + 1;
    }

    private static int heightTree(Node root) {
        if(root == null) return -1;

        return Math.max(heightTree(root.left), heightTree(root.right)) + 1;
    }
}
