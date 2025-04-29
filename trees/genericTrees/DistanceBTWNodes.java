package com.trees.genericTrees;

import java.util.ArrayList;
import java.util.List;

import static com.trees.genericTrees.ImplementationWithEulerArray.implementation;
import static com.trees.genericTrees.NodeToRootPath.findPath;

public class DistanceBTWNodes {
    public static void main(String[] args) {
        int[] euler_array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
                -1, -1, 90, -1, -1, 40, 130};
        Node root = implementation(euler_array);
        System.out.println(distance(root, 50, 120));
    }

    private static int distance(Node root, int node1, int node2) {
        List<Node> NTR1 = findPath(root, node1);
        List<Node> NTR2 = findPath(root, node2);

        int i = NTR1.size() - 1;
        int j = NTR2.size() - 1;

        while(i >= 0 && j >= 0 && NTR1.get(i).val == NTR2.get(j).val){
            i--; j--;
        }
        int ans =0;
        if(i >= 0) ans+= i + 1;
        if(j >= 0) ans+= j + 1;
        return ans;
    }
}
