package com.trees.genericTrees;

import java.util.ArrayList;
import java.util.List;

import static com.trees.genericTrees.ImplementationWithEulerArray.implementation;

public class NodeToRootPath {
    public static void main(String[] args) {
        int[] euler_array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
                -1, -1, 90, -1, -1, 40, 130};
        Node root = implementation(euler_array);
        List<Node> ans = findPath(root, 110);
        for(Node node: ans){
            System.out.print(node.val + " ");
        }
    }

    public static List<Node> findPath(Node root, int toFind){
        if(root.val == toFind){
            List<Node> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }

        for(Node child: root.children){
            List<Node> getChildPath = findPath(child, toFind);
            if(!getChildPath.isEmpty()){
                getChildPath.add(root);
                return getChildPath;
            }
        }
        return new ArrayList<>();
    }
}
