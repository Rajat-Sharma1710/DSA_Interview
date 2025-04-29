package com.trees.binaryTrees;

public class PrintKLevel {
    public static void main(String[] args) {
        Node root = Node.implementation2();
        int level = 3;
        printKthLevel(root, 0, level);
    }

    private static void printKthLevel(Node root, int step, int level){
        if(root == null){
            return;
        }
        if(step == level){
            System.out.print(root.val + " ");
            return;
        }
        printKthLevel(root.left, step + 1, level);
        printKthLevel(root.right, step + 1, level);
    }
}
