package com.trees.genericTrees;

import static com.trees.genericTrees.ImplementationWithEulerArray.implementation;

public class AreTreesMirror {
    public static void main(String[] args) {
        int[] euler_array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
                -1, -1, 90, -1, -1, 40, 130};
        int[] euler_2 = {10, 40, 130, -1, -1, 30, 90, -1, 80, -1, 70, 110, -1, 120,
                -1, -1, -1, 20, 60, -1, 50};
//        int[] euler_2 = {10, 40, 130, -1, -1, 30, 90, -1, 80, 110, -1, 120, -1, -1, 70,
//                -1, -1, 20, 60, -1, 50}; // true Mirror
        Node root1 = implementation(euler_array);
        Node root2 = implementation(euler_2);

        System.out.println(areMirror(root1, root2));
    }

    private static boolean areMirror(Node root1, Node root2) {
        if(root1.children.size() != root2.children.size()){
            return false;
        }
        for(int i = 0; i < root1.children.size(); i++){
            boolean areChildMirror = areMirror(root1.children.get(0),
                                    root2.children.get(root2.children.size() - i - 1));
            if(!areChildMirror){
                return false;
            }
        }
        return true;
    }


}
