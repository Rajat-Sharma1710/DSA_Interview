package com.trees.binarySearchTrees;

public class Node {
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
    }
    public Node (int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static Node construct(int[] arr, int lo, int hi) {
        if(lo > hi){
            return null;
        }
        int mid = (lo + hi) / 2;

        Node ln = construct(arr, lo, mid - 1);
        Node rn = construct(arr, mid + 1, hi);

        return new Node(arr[mid], ln, rn);
    }

    public static Node construct_2() {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(3);
        root.right.right = new Node(6);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87};
        Node root = construct(arr, 0, arr.length - 1);
        preOrder(root);
        System.out.println();
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static Node findNode(Node root, int val){
        if(root == null){
            return null;
        }
        if(val < root.val){
            return findNode(root.left, val);
        } else if(val > root.val){
            return findNode(root.right, val);
        } else {
            return root;
        }
    }
}
