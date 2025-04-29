package com.trees.binaryTrees;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.trees.binaryTrees.Node.implementation;

public class BFSTraversal {
    public static void main(String[] args) {
        Node root = implementation();
        bfsTraversal(root);
    }

    private static void bfsTraversal(Node root){
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        que.add(new Node(-1));
        while(!que.isEmpty()){
            boolean flag = false;
            while(que.peek().val != -1){
                Node remove = que.remove();
                System.out.print(remove.val + " ");
                if(que.peek().val == -1){
                    flag = true;
                }
                if(remove.left != null){
                    que.add(remove.left);
                }
                if(remove.right != null){
                    que.add(remove.right);
                }
                if(flag){
                    que.add(new Node(-1));
                }
            }
            if(que.peek().val == -1){
                System.out.println();
                que.remove();
            }
        }
    }
}
