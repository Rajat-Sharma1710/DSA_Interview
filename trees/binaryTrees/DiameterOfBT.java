package com.trees.binaryTrees;

import static com.trees.binaryTrees.DFSTraversal.preOrder;

public class DiameterOfBT {
    int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root = Node.implementation4();
        System.out.println(diameter(root));
    }

    private static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diaOnLeft = diameter(root.left);
        int diaOnRight = diameter(root.right);

        int diaThrRoot = height(root.left) + height(root.right) + 2;

        return Math.max(diaThrRoot, Math.max(diaOnLeft, diaOnRight));
    }

    static int height(Node root){
        if(root == null){
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
