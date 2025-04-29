package com.graphs;

import java.util.*;

public class wordLadder1 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        int trans = ladderLength(beginWord, endWord, wordList);
        System.out.println(trans);
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, wordList.toArray(new String[0]));
        if(!set.contains(endWord)) return 0;

        int transformations = 1;
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        set.remove(beginWord);
        while(!que.isEmpty()){
            int len = que.size();
            for(int k = 0; k < len; k++){
                String out = que.poll();
                char[] arr = out.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    char temp = arr[i];
                    for(int j = 0; j < 26; j++){
                        char ch = (char) ('a' + j);
                        arr[i] = ch;
                        String nextWord = new String(arr);
                        if(nextWord.equals(endWord)){
                            return transformations + 1;
                        }
                        if(set.contains(nextWord)) {
                            que.add(nextWord);
                            set.remove(nextWord);
                        }
                    }
                    arr[i] = temp;
                }
            }
            transformations++;
        }
        // transformations are either way increasing, so can't return transformations
        return 0;
    }
}
