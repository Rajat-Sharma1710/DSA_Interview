package com.graphs.directed;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CourseSchedule_II {
    static int cnt;
    static boolean flag;
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
        int n = 5, m = 45;
        pre.add(new ArrayList<>(Arrays.asList(1, 0)));
        pre.add(new ArrayList<>(Arrays.asList(2, 1)));
        pre.add(new ArrayList<>(Arrays.asList(4, 2)));
        pre.add(new ArrayList<>(Arrays.asList(3, 2)));
        pre.add(new ArrayList<>(Arrays.asList(1, 4)));

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(ArrayList<Integer> pair: pre) {
            int temp = pair.get(0);
            pair.set(0, pair.get(1));
            pair.set(1, temp);

            map.computeIfAbsent(pair.get(0), list -> new ArrayList<>()).add(pair.get(1));
        }

//        System.out.println(map);

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        int[] ans = new int[n];
        cnt = n - 1;
        flag = false;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                vis[i] = true;
                pathVis[i] = true;
                func(i, n, m, map, vis, pathVis, ans);
            }
        }

        for(int ele: ans){
            System.out.print(ele + " ");
        }
    }

    private static void func(int vertex, int n, int m, Map<Integer, ArrayList<Integer>> map,
                             boolean[] vis, boolean[] pathVis, int[] ans) {
        if(flag) return;
        if(map.containsKey(vertex)) {
            for (Integer nei : map.get(vertex)) {
                if(flag) return;
                if (!vis[nei]) {
                    vis[nei] = true;
                    pathVis[nei] = true;
                    func(nei, n, m, map, vis, pathVis, ans);
                } else if (pathVis[nei]) {
                    flag = true;
                    return;
                }
            }
        }

        ans[cnt--] = vertex;
        pathVis[vertex] = false;
    }
}
