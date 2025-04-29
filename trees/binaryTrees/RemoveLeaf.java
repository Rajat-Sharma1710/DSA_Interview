package com.trees.binaryTrees;

public class RemoveLeaf {
    public static void main(String[] args) {
        Node root = Node.implementation3();
        remove(root);

        DFSTraversal.preOrder(root);
    }

    private static Node remove(Node root){
        if(root == null || root.left == null && root.right == null){
            return null;
        }
        Node left = remove(root.left);
        Node right = remove(root.right);

        root.left = left;
        root.right= right;

        return root;
    }
}
