package com.trees.binaryTrees;

import java.util.ArrayList;
import java.util.List;

import static com.trees.binaryTrees.Node.implementationBoundary_1;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = implementationBoundary_1();
        List<Integer> ans = boundary(root);
        System.out.println(ans);
    }

    private static List<Integer> boundary(Node root) {
        List<Integer> list = new ArrayList<>();
        leftView(root, list);
        System.out.println("Left View is " + list);
        List<Integer> listA = new ArrayList<>();
        findLeaves(root, listA);
        listA.remove(0);
        listA.remove(listA.size() - 1);

        System.out.println("Leaves are " +  listA);
        for(int ele: listA) list.add(ele);

        rightView(root, list);
        list.remove(list.size() - 1);

        return list;
    }

    private static void leftView(Node root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        leftView(root.left, list);
    }

    private static void rightView(Node root, List<Integer> list) {
        if(root == null) return;
        rightView(root.right, list);
        list.add(root.val);
    }

    private static void findLeaves(Node root, List<Integer> list) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        findLeaves(root.left, list);
        findLeaves(root.right, list);
    }
}
