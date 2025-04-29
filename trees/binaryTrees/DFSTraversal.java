package com.trees.binaryTrees;

public class DFSTraversal {
    public static void main(String[] args) {
        Node root = Node.implementation();
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    private static void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    private static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
