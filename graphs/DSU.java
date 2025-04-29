package com.graphs;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class DSU {
    List<Integer> rank;
    List<Integer> parent;
    List<Integer> size;

    public DSU(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltimateParent(int u) {
        if(parent.get(u) == u) return u;
        parent.set(u, findUltimateParent(parent.get(u)));
        return parent.get(u);
    }

    public void unionByRank(int u, int v) {
        int ult_pu = findUltimateParent(u);
        int ult_pv = findUltimateParent(v);

        int ru = rank.get(ult_pu);
        int rv = rank.get(ult_pv);

        if(ru < rv) {
            parent.set(ult_pu, ult_pv);
        } else if(rv < ru){
            parent.set(ult_pv, ult_pu);
        } else {
            parent.set(ult_pv, ult_pu);
            rank.set(ult_pu, rank.get(ult_pu) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ult_pu = findUltimateParent(u);
        int ult_pv = findUltimateParent(v);

        int size_u = size.get(ult_pu);
        int size_v = size.get(ult_pv);

        if(size_v < size_u) {
            parent.set(ult_pv, ult_pu);
            size.set(ult_pu, size.get(ult_pu) + size.get(ult_pv));
        } else {
            parent.set(ult_pu, ult_pv);
            size.set(ult_pv, size.get(ult_pu) + size.get(ult_pv));
        }
    }
}

class Main {
    public static void main(String[] args) {
        DSU obj = new DSU(7);
        obj.unionBySize(1, 2);
        obj.unionBySize(2, 3);
        obj.unionBySize(4, 5);
        obj.unionBySize(6, 7);
        obj.unionBySize(5, 6);

        if(obj.findUltimateParent(3) == obj.findUltimateParent(6)){
            System.out.println("Components 3 and 6 are connected");
        } else {
            System.out.println("Components 3 and 6 are not connected");
        }

        obj.unionBySize(3, 7);

        if(obj.findUltimateParent(3) == obj.findUltimateParent(6)){
            System.out.println("Components 3 and 6 are connected");
        } else {
            System.out.println("Components 3 and 6 are not connected");
        }
    }
}
