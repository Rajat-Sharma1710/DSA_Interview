package com.trees.binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = Node.implementation();
        List<List<Integer>> ans = levelOrderTraversal(root);
    }

    private static List<List<Integer>> levelOrderTraversal(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int cnt = que.size();
            while(cnt-- > 0) {
                Node rem = que.poll();
                list.add(rem.val);
                if(rem.left != null) que.add(rem.left);
                if(rem.right != null) que.add(rem.right);
            }
            ans.add(list);
        }
        return ans;
    }
}
