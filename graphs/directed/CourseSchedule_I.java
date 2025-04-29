package com.graphs.directed;

import java.util.*;

public class CourseSchedule_I {
    public static void main(String[] args) {
        int n = 5;
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};

        int m = prerequisites.length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int[] pair: prerequisites) {
            int temp = pair[0];
            pair[0] = pair[1];
            pair[1] = temp;

            map.computeIfAbsent(pair[0], list -> new ArrayList<>()).add(pair[1]);
        }

        System.out.println(map);

        boolean[] vis = new boolean[n];
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++) {
            if(map.containsKey(i)){
                for(int ele: map.get(i)){
                    indegree[ele]++;
                }
            }
        }
        int cnt = 0;
        boolean ans = func(map, n, m, vis, indegree, cnt);
        System.out.println(ans);
    }

    private static boolean func(Map<Integer, ArrayList<Integer>> map, int n, int m, boolean[] vis, int[] indegree, int cnt) {
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                vis[i] = true;
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int ele = que.poll();
            cnt++;

            if(map.containsKey(ele)){
                for(int adj: map.get(ele)){
                    if(!vis[adj]){
                        vis[adj] = true;
                        indegree[adj]--;
                        if(indegree[adj] == 0){
                            que.add(adj);
                        }
                    }
                }
            }
        }

        return cnt == n;
    }
}
