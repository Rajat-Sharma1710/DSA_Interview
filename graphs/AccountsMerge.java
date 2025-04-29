package com.graphs;

import com.sun.source.tree.Tree;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        /*
             [["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],
             ["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],
             ["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],
             ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],
             ["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]
         */
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> finalAccnt = mergeAccounts(accounts);
        System.out.println(finalAccnt);

        Map<Integer, Integer> map1 = new TreeMap<>();
        map1.put(0, 5);
        map1.put(9, 1);
        map1.put(-1, 6);
        map1.put(4, 3);
        map1.put(-2, 3);

        System.out.println(map1);
    }

    private static List<List<String>> mergeAccounts(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        int space = 1;
        for(List<String> list: accounts) {
            String name = list.get(0);
            if(!map.containsKey(name)){
                PriorityQueue<String> pq = new PriorityQueue<>();
                for(int i = 1; i < list.size(); i++) {
                    pq.add(list.get(i));
                }
                map.put(name, pq);
            } else {
                PriorityQueue<String> pq = map.get(name);
                boolean isPresent = false;
                for(int i = 1; i < list.size(); i++) {
                    if(pq.contains(list.get(i))){
                        isPresent = true;
                        break;
                    }
                }

                if(isPresent) {
                    for(int i = 1; i < list.size(); i++){
                        if(!pq.contains(list.get(i)))
                            pq.add(list.get(i));
                    }
                } else {
                    StringBuilder sb = new StringBuilder(name);
                    for(int i = 0; i < space; i++){
                        sb.append(" ");
                    }
                    space++;
                    PriorityQueue<String> set_1 = new PriorityQueue<>();
                    for(int i = 1; i < list.size(); i++) {
                        set_1.add(list.get(i));
                    }

                    map.put(sb.toString(), set_1);
                }
            }
        }

//        System.out.println(map);
        for(Map.Entry<String, PriorityQueue<String>> entrySet: map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(entrySet.getKey().trim());
            PriorityQueue<String> pq = entrySet.getValue();
            while(!pq.isEmpty()){
                list.add(pq.remove());
            }

            ans.add(list);
        }
        Collections.sort(ans, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return 0;
            }
        });

        return ans;
    }
}
