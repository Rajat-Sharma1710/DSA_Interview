package com.trees.binaryTrees;

public class Node {
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
    }

    public static Node implementation(){
        Node root =  new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public static Node implementation2(){
        Node root =  new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);
        return root;
    }

    // Use when concerned with Node values...
    public static Node implementation3() {
        Node root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);

        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);

        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);
        return root;
    }

    // A larger tree for Diameter
    public static Node implementation4(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);
        root.right.left.right = new Node(10);

        root.left.left.left.right = new Node(11);
        root.left.left.left.right.right = new Node(12);
        root.left.left.left.right.right.left = new Node(13);

        return root;
    }

    /*
            1
          2   3
        4       5
      6           7
     */
    public static Node implementation5() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.right.right = new Node(5);

        root.left.left.left = new Node(6);
        root.right.right.right = new Node(7);
        return root;
    }

    public static Node verticalImplementation() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(6);

        root.left.left = new Node(3);
        root.left.right = new Node(9);

        root.right.left = new Node(8);
        root.right.right = new Node(7);

        root.left.left.right = new Node(4);
        root.left.left.right.right = new Node(10);
        return root;
    }

    public static Node implementation10() {
        Node root = new Node(6);
        root.left = new Node(9);
        root.right = new Node(4);

        root.right.left = new Node(8);

        root.right.left.right = new Node(3);
        return root;
    }

    public static Node implementation11() {
        Node root = new Node(1);
        root.left = new Node(2);

        return root;
    }

    public static Node implementationBoundary_1() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(5);

        root.left.right.left = new Node(6);
        root.left.right.left.left = new Node(7);
        root.left.right.left.right = new Node(8);

        return root;
    }
}
