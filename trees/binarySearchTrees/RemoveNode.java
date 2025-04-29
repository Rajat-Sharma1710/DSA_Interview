package com.trees.binarySearchTrees;

import static com.trees.binarySearchTrees.Node.preOrder;

public class RemoveNode {
    public static void main(String[] args) {
        int[] arr = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
        Node root = Node.construct(arr, 0, arr.length - 1);
        removeNode(root, 70);
        preOrder(root);
    }

    private static Node removeNode(Node root, int val) {
        if (val > root.val) {
            root.right = removeNode(root.right, val);
        } else if (val < root.val) {
            root.left = removeNode(root.left, val);
        } else {
            if (root.left != null && root.right != null) {
                Node max = findMax(root.left);
                root.val = max.val;
                root.left = removeNode(root.left, max.val);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }
        return root;
    }

    private static Node findMax(Node root){
        if(root.right != null){
            return findMax(root.right);
        } else {
            return root;
        }
    }
}
