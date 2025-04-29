package com.trees.binarySearchTrees;

public class PrintNodesInRange {
    public static void main(String[] args) {
        int[] arr = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
        Node root = Node.construct(arr, 0, arr.length - 1);
        rangeNodes(root, 27, 72);
    }

    private static void rangeNodes(Node root, int r1, int r2){
        if(root == null){
            return;
        }
        if(root.val >= r1 && root.val <= r2){
            rangeNodes(root.left, r1, r2);
            System.out.print(root.val + " ");
            rangeNodes(root.right, r1, r2);
        }
    }
}
