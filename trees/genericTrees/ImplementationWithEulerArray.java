package com.trees.genericTrees;

import java.util.ArrayList;
import java.util.Stack;

public class ImplementationWithEulerArray {
    public static void main(String[] args) {
        int[] euler_array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 130};
        /*
            The tree looks like below
                        10
                 20             30
               50   60      70      80
                                110     120
         */

        Node root = implementation(euler_array);
//        display(root);
        System.out.println("Size of the Tree is " + sizeOfTree(root));

        System.out.println("Maximum element in the tree is " + maxInTree(root));
        System.out.println("Height of the Tree is " + heightOfTree(root));

        System.out.print("Preorder Traversal -> ");
        preorderTraversal(root);
        System.out.println();
        System.out.print("Postorder Traversal -> ");
        postorderTraversal(root);
    }

    public static Node implementation(int[] euler_array){
        Stack<Node> st = new Stack<>();
        Node root = null;
        for(int i = 0; i < euler_array.length; i++){
            if(st.isEmpty()){
                root = new Node(euler_array[i], new ArrayList<>());
                st.push(root);
            } else {
                if(euler_array[i] == -1){
                    st.pop();
                } else {
                    Node newNode = new Node(euler_array[i], new ArrayList<>());

                    Node parent = st.peek();
                    parent.children.add(newNode);
                    st.push(newNode);
                }
            }
        }
        return root;
    }

    private static void display(Node root){
        String str = root.val + "-> ";
        for(Node child: root.children){
            str += child.val + ", ";
        }
        str += ".";
        System.out.println(str);

        for(Node child: root.children){
            display(child);
        }
    }

    private static int sizeOfTree(Node root){
        int size = 0;
        for(Node child: root.children){
            size += sizeOfTree(child);
        }
        return size + 1;
    }

    private static int maxInTree(Node root){
        int max = Integer.MIN_VALUE;
        for(Node child: root.children){
            max = Math.max(max, maxInTree(child));
        }
        max = Math.max(max, root.val);
        return max;
    }

    private static int heightOfTree(Node root){
        // if asks for node then initialize with 0, cause for a single node eg. 10 height is 0 not 1
        int maxHeight = -1;
        for(Node child: root.children){
            maxHeight = Math.max(maxHeight, heightOfTree(child));
        }

        return maxHeight + 1;
    }

    public static void preorderTraversal(Node root){
        System.out.print(root.val + " ");
        for(Node child: root.children){
            preorderTraversal(child);
        }
    }

    public static void postorderTraversal(Node root){
        for(Node child: root.children){
            postorderTraversal(child);
        }
        System.out.print(root.val + " ");
    }
}
