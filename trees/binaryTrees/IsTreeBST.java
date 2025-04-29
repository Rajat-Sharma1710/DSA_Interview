package com.trees.binaryTrees;

public class IsTreeBST {
    static class BSTPair{
        boolean isBST;
        int min;
        int max;
    }
    public static void main(String[] args) {
        Node root = Node.implementation3();
//        DFSTraversal.preOrder(root);
        BSTPair pair = isBST(root);
        System.out.println(pair.isBST);
    }

    private static BSTPair isBST(Node root) {
        if(root == null){
            BSTPair pair = new BSTPair();
            pair.isBST = true;
            pair.min = Integer.MAX_VALUE;
            pair.max = Integer.MIN_VALUE;
            return pair;
        }
        BSTPair lp = isBST(root.left);
        BSTPair rp = isBST(root.right);

        BSTPair myPair = new BSTPair();
        // This is BST when it is BST as a node and BST as a Tree
        myPair.isBST = (root.val >= lp.max && root.val <= rp.min) && lp.isBST && rp.isBST;
        // min is min out of left, right and himself ---- same for maximum
        // and for that only ->
        // To find the min and max for myself I need the min and max of my children (**** IMP)
        myPair.min = Math.min(root.val, Math.min(lp.min, rp.min));
        myPair.max = Math.max(root.val, Math.max(lp.max, rp.max));

        return myPair;
    }
}
