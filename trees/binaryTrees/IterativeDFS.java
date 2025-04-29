package com.trees.binaryTrees;

import java.util.Stack;

public class IterativeDFS {
    public static void main(String[] args) {
        Node root = Node.implementation();
        itPreorder(root);
        System.out.println();
        itInorder(root);
    }

    private static void itPreorder(Node root) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node remove = st.pop();
            System.out.print(remove.val +" ");
            if(remove.right != null){
                st.push(remove.right);
            }
            if(remove.left != null){
                st.push(remove.left);
            }
        }
    }

    // Important Code....
    private static void itInorder(Node root){
        Stack<Node> st = new Stack<>();
        Node node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            } else {
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

}
