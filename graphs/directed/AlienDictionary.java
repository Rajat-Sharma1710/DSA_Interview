package com.graphs.directed;

import java.util.ArrayList;

/*
    Multiple Wrong Attempts includes scenarios/edge cases didn't cover are -
        1. If some character were never part of the adj list, include it in the last using freq[]
        2. There is possibility that the ans string returned was empty even if the graph is DAG,
           for that use a flag to check if there is a cycle or not.
 */
public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"z", "z"};
//        Set<Character> set = new HashSet<>();
        int max = -1;
        int[] freq = new int[26];
        for(String word: words){
            for(char ch: word.toCharArray()){
                freq[ch - 'a']++;
                if(ch - 'a' > max){
                    max = (ch - 'a');
                }
            }
        }
        boolean flag = false;
        StringBuilder ans = getAlienOrder(words, max + 1, flag);
        if(!flag) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    boolean isPresent = false;
                    char ch = (char) (i + 'a');
                    for (int j = 0; j < ans.length(); j++) {
                        if (ans.charAt(j) == ch) {
                            isPresent = true;
                            break;
                        }
                    }
                    if (!isPresent) {
                        ans.append(ch);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static StringBuilder getAlienOrder(String[] words, int n, boolean flag) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < words.length - 1; i++){
            String a = words[i];
            String b = words[i + 1];

            int j = 0;
            int min = Math.min(a.length(), b.length());
            while(j < min){
                if(a.charAt(j) != b.charAt(j)){
                    adj.get(a.charAt(j) - 'a').add(b.charAt(j) - 'a');
                    break;
                }
                j++;
            }

            if(a.length() > b.length()){
                if(smallMatches(a, b)){
                    flag = true;
                    return new StringBuilder("");
                }
            }
        }

        boolean[] vis = new boolean[adj.size()];
        boolean[] pathVis = new boolean[adj.size()];
        boolean isCycle = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < adj.size(); i++){
            if(!vis[i] && !adj.get(i).isEmpty()){
                vis[i] = true;
                pathVis[i] = true;
                if(isCycle(adj, i, vis, pathVis, sb)) {
                    isCycle = true;
                    flag = true;
                    break;
                }
            }
        }

        if(isCycle) return new StringBuilder("");
        return sb.reverse();
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] vis, boolean[] pathVis, StringBuilder sb) {
        for(int ele: adj.get(vertex)) {
            if(!vis[ele]){
                vis[ele] = true;
                pathVis[ele] = true;
                if(isCycle(adj, ele, vis, pathVis, sb)){
                    return true;
                }
            } else if(pathVis[ele]){
                return true;
            }
        }

        pathVis[vertex] = false;
        char ch = (char) (vertex + 'a');
        sb.append(ch);
        return false;
    }

    private static boolean smallMatches(String a, String b){
        for(int i = 0; i < b.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
