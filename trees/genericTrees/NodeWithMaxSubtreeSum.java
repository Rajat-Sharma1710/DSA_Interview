package com.trees.genericTrees;

import static com.trees.genericTrees.ImplementationWithEulerArray.implementation;

public class NodeWithMaxSubtreeSum {
    static int max = Integer.MIN_VALUE;
    static Node maxNode;
    public static void main(String[] args) {
        int[] euler_array = {10, 20, -50, -1, -60, -1, -1, -30, -70, -1, 80, -110, -1, 120,
                -1, -1, 90, -1, -1, 40, 130};
        Node root = implementation(euler_array);
        maxSubtreeSumNode(root);
        System.out.println(maxNode.val + "@" + max);
    }

    private static int maxSubtreeSumNode(Node root) {
        int sum = 0;
        for(Node child: root.children){
            sum += maxSubtreeSumNode(child);
        }

        sum += root.val;
        if(sum > max){
            max = sum;
            maxNode = root;
        }
        return sum;
    }
}
