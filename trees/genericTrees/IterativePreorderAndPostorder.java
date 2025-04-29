package com.trees.genericTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.trees.genericTrees.ImplementationWithEulerArray.implementation;

public class IterativePreorderAndPostorder {
    static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void main(String[] args) {
        int[] euler = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, 70};
        Node root = implementation(euler);
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        iterative(root, preOrder, postOrder);
        System.out.println("Preorder Traversal -> " + preOrder);
        System.out.println("Postorder Traversal -> " + postOrder);
    }

    private static void iterative(Node root, List<Integer> preorder, List<Integer> postorder) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, -1));

        while(!st.isEmpty()){
            Pair p = st.peek();
            if(p.state == -1){
                preorder.add(p.node.val);
                p.state = 0;
            } else if(p.state == p.node.children.size()){
                postorder.add(p.node.val);
                st.pop();
                if(!st.isEmpty())
                    st.peek().state++;
            } else {
                st.push(new Pair(p.node.children.get(p.state), -1));
            }
        }
    }
}
