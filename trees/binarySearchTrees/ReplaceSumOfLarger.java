package com.trees.binarySearchTrees;

import static com.trees.binarySearchTrees.Node.preOrder;

public class ReplaceSumOfLarger {
    static int sum;
    public static void main(String[] args) {
        int[] arr = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
        Node root = Node.construct(arr, 0, arr.length - 1);
        preOrder(replace(root));
    }

    private static Node replace(Node node){
        if(node == null){
            return null;
        }
        replace(node.right);

        int nodeOriVal = node.val;
        node.val = sum;
        sum += nodeOriVal;

        replace(node.left);
        return node;
    }
}
