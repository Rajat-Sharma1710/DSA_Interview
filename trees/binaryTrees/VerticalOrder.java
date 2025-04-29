package com.trees.binaryTrees;

import java.util.*;

public class VerticalOrder {
    public static void main(String[] args) {
        Node root = Node.verticalImplementation();

        List<List<Integer>> ans = vertical(root);
        System.out.println(ans);
    }

    private static List<List<Integer>> vertical(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0));
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        map.put(0, list);
        while(!que.isEmpty()) {
            int cnt = que.size();
            // sort by values when same index
            List<Pair> listIndx = new ArrayList<>(que);
            listIndx.sort(new Comp());
            que.clear();
            que.addAll(listIndx);
            // DOESN'T WORK.....
            while(cnt-- > 0) {
                Pair rem = que.poll();
                if(rem.node.left != null) {
                    que.add(new Pair(rem.node.left, rem.indx - 1));
                    if(map.containsKey(rem.indx - 1)) {
                        List<Integer> list1 = map.get(rem.indx - 1);
                        list1.add(rem.node.left.val);
                    } else {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(rem.node.left.val);
                        map.put(rem.indx - 1, list1);
                    }
                }
                if(rem.node.right != null) {
                    que.add(new Pair(rem.node.right, rem.indx + 1));
                    if(map.containsKey(rem.indx + 1)) {
                        List<Integer> list1 = map.get(rem.indx + 1);
                        list1.add(rem.node.right.val);
                    } else {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(rem.node.right.val);
                        map.put(rem.indx + 1, list1);
                    }
                }
            }
        }
//        System.out.println(map);

        for(Map.Entry<Integer, List<Integer>> entrySet: map.entrySet()) {
            ans.add(entrySet.getValue());
        }

        return ans;
    }
}

class Pair{
    Node node;
    int indx;

    public Pair (Node node, int indx) {
        this.node = node;
        this.indx = indx;
    }
}

class Comp implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        if(p1.indx != p2.indx) {
            return p1.indx - p2.indx;
        } else {
            return p1.node.val - p2.node.val;
        }
    }
}
