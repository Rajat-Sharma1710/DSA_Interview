package com.trees.binaryTrees;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeDFSUsingStates {
    static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void main(String[] args) {
        Node root = Node.implementation();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        iterative(root, preOrder, inOrder, postOrder);
        System.out.println("Preorder Traversal -> " + preOrder);
        System.out.println("Inorder Traversal -> " + inOrder);
        System.out.println("Postorder Traversal -> " + postOrder);
    }

    private static void iterative(Node root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while(!st.isEmpty()){
            Pair p = st.peek();
            if(p.state == 1){
                pre.add(p.node.val);
                st.peek().state = 2;
                if(p.node.left != null){
                    st.push(new Pair(p.node.left, 1));
                }
            } else if(p.state == 2){
                in.add(p.node.val);
                st.peek().state = 3;
                if(p.node.right != null){
                    st.push(new Pair(p.node.right, 1));
                }
            } else {
                post.add(p.node.val);
                st.pop();
            }
        }
    }
}
