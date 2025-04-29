package com.trees.binaryTrees;

import static com.trees.binaryTrees.DiameterOfBT.height;

public class Diameter {
    static int ans = -1;
    public static void main(String[] args) {
//        Node root = Node.implementation10();
//        dia(root);
        Node root = Node.implementation11();
        dia1(root);
        System.out.println(ans);
    }

    private static int dia(Node root) {
        if(root == null){
            return 0;
        }

        int left = dia(root.left);
        int right = dia(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }

    private static int dia1(Node root) {
        if(root == null){
            return 0;
        }

        int dia = -1;
        if(root.left != null && root.right != null){
            dia = height(root.left) + height(root.right) + 2;
        } else if(root.left != null || root.right != null) {
            dia = height(root.left) + height(root.right) + 1;
        } else {
            dia = 0;
        }
        if(dia > ans) {
            ans = dia;
        }

        int left = dia1(root.left);
        int right = dia1(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
