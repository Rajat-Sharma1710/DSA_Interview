package com.trees.genericTrees;

import java.util.Collections;

import static com.trees.genericTrees.ImplementationWithEulerArray.*;

public class MirrorOfTree {
    public static void main(String[] args) {
        int[] euler_array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120};
        Node root = implementation(euler_array);
        mirror(root);
        preorderTraversal(root);
    }

    private static void mirror(Node root){
        for(Node child: root.children){
            mirror(child);
        }
        Collections.reverse(root.children);
    }
}
