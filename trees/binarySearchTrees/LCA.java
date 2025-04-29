package com.trees.binarySearchTrees;

public class LCA {
    public static void main(String[] args) {
        int[] arr = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
        Node root = Node.construct(arr, 0, arr.length - 1);
        Node ans = lca(root, 37, 40);
        System.out.println(ans.val);
    }

    private static Node lca(Node node, int val1, int val2){
        if(node == null){
            return null;
        }
        if(node.val >= val1 && node.val <= val2){
            return node;
        } else if(node.val < val1){
            return lca(node.right, val1, val2);
        } else {
            return lca(node.left, val1, val2);
        }
    }
}
