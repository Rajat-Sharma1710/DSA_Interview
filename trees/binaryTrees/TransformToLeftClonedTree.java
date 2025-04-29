package com.trees.binaryTrees;

public class TransformToLeftClonedTree {
    public static void main(String[] args) {
        Node root = Node.implementation2();
        Node cloned = transformToLeftCloned(root);
        DFSTraversal.preOrder(cloned);
        System.out.println();
        System.out.println("-----------------");
//        Node back = transformBackFromLeftCloned(cloned, 0);
//        DFSTraversal.preOrder(back);

        Node back = transformBackFromLeftCloned_simple(root);
        DFSTraversal.preOrder(back);
    }

    private static Node transformToLeftCloned(Node root) {
        if(root == null){
            return null;
        }
        Node left = transformToLeftCloned(root.left);
        Node right = transformToLeftCloned(root.right);

        Node newNode = new Node(root.val);
        root.left = newNode;
        root.right = right;
        newNode.left = left;
        return root;
    }

    private static Node transformBackFromLeftCloned(Node root, int pointer){
        if(root == null){
            return null;
        }

        Node left = transformBackFromLeftCloned(root.left, pointer + 1);
        Node right = transformBackFromLeftCloned(root.right, pointer);

        if(pointer % 2 == 1){
            root.left = left;
            root.right = right;
        } else {
            Node toAttach = root.left.left;
            root.left.left = null;
            root.left = toAttach;
        }
        return root;
    }

    private static Node transformBackFromLeftCloned_simple(Node root){
        if(root == null){
            return null;
        }
        Node left = transformBackFromLeftCloned_simple(root.left.left);
        Node right = transformBackFromLeftCloned_simple(root.right);

        root.left = left;
        root.right = right;

        return root;
    }

}
