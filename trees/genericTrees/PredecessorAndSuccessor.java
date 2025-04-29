package com.trees.genericTrees;

import static com.trees.genericTrees.ImplementationWithEulerArray.implementation;

public class PredecessorAndSuccessor {
    static Node predecessor;
    static Node successor;
    public static void main(String[] args) {
        int[] euler_array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
                -1, -1, 90, -1, -1, 40, 130};
        Node root = implementation(euler_array);
        find(root, 130);
        System.out.println(predecessor.val + " " + successor.val);
    }

    // fails for the nodes having no predecessor or successor !!
    private static void find(Node root, int node) {
        if(predecessor != null && node != root.val){
            successor = root;
            return;
        }
        for(Node child: root.children){
            if(node == child.val){
                predecessor = root;
            }
            find(child, node);
            if(predecessor != null & successor != null) return;
        }
    }
}
