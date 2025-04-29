package com.trees.binaryTrees;

import java.util.Stack;

public class IterativeInOrder {
    public static void main(String[] args) {
        Node root = Node.implementation();
        inOrderIT(root);
    }

    private static void inOrderIT(Node root) {

        Stack<Node> st = new Stack<>();
//        st.push(root);
        Node curr = root;
        while(curr != null || !st.isEmpty()) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                Node rem = st.pop();
                System.out.print(rem.val + " ");

                curr = rem.right;
            }
        }
    }
}
