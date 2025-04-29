package com.trees.binaryTrees;

public class NodeToRootPath {
    public static void main(String[] args) {
        Node root = Node.implementation2();
        path(root, 8);
    }

    public static boolean path(Node root, int val) {
        if(root == null){
            return false;
        }
        if(root.val == val){
            System.out.print(root.val + " -> ");
            return true;
        }
        boolean findInLeft = path(root.left, val);
        if(findInLeft){
            System.out.print(root.val + " -> ");
            return true;
        }
        boolean findInRight = path(root.right, val);
        if(findInRight){
            System.out.print(root.val + " -> ");
            return true;
        }

        return false;
    }
}
