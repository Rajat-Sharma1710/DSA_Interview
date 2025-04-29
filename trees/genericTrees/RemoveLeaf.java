package com.trees.genericTrees;

import static com.trees.genericTrees.ImplementationWithEulerArray.*;

public class RemoveLeaf {
    public static void main(String[] args) {
        int[] euler_array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
        -1, -1, 90, -1, -1, 40, 130};
        Node root = implementation(euler_array);
        removeLeaf(root);
    }

    private static void removeLeaf(Node root){

        /* we can't run forEach loop, as it ends up getting ConcurrentModification Exception,
           also, we need to first delete the children whose children are empty and then check their children
           respectively.(PreOrder)
         */
        for(int i = root.children.size() - 1; i >= 0; i--){
            Node child = root.children.get(i);
            if(child.children.isEmpty()){
                System.out.print(child.val + " ");
                root.children.remove(child);
            }
        }
        for(Node child: root.children){
            removeLeaf(child);
        }

    }
}
