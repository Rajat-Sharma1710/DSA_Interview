package com.trees.binarySearchTrees;

import static com.trees.binarySearchTrees.Node.preOrder;

public class AddNode {
    public static void main(String[] args) {
        int[] arr = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
        Node root = Node.construct(arr, 0, arr.length - 1);
        addNodeToBST(root, 33);
        preOrder(root);
    }

    /*
        Important recursion trick, if while traversing you reach out to null,
        and then you create the new node, but how would you attach the newly created node
        to its parent which is just previous recursive call.
     */
    private static Node addNodeToBST(Node root, int toAdd){
        if(root == null){
            return new Node(toAdd);
        }
        if(toAdd < root.val){
            root.left = addNodeToBST(root.left, toAdd);
        } else {
            root.right = addNodeToBST(root.right, toAdd);
        }
        return root;
    }
}
