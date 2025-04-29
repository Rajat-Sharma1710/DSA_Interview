package com.trees.genericTrees;

import static com.trees.genericTrees.ImplementationWithEulerArray.implementation;
/*
    Important Good Question/Concept
 */
public class DiameterOfTree {
    static int diameter;
    public static void main(String[] args) {
        int[] euler_array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
                -1, -1, 90, -1, -1, 40, 130};
        Node root = implementation(euler_array);
        deepestHeight(root);
        System.out.println(diameter);
    }

    /*
        In this method we are calculating deepest and secondDeepest height of the
        children so that in next step we can calculate the diameter, but we are
        returning the deepest height for this function ->
        A good example of calculating something else but returning something else.....
     */
    private static int deepestHeight(Node root) {
        int deepestHeight = -1;
        int secondDeepestHeight = -1;
        for(Node child: root.children){
            int height = deepestHeight(child);
            if(height > deepestHeight){
                secondDeepestHeight = deepestHeight;
                deepestHeight = height;
            } else if(height > secondDeepestHeight){
                secondDeepestHeight = height;
            }
        }

        if(deepestHeight + secondDeepestHeight + 2 > diameter){
            diameter = deepestHeight + secondDeepestHeight + 2;
        }

        return deepestHeight + 1;
    }
}
