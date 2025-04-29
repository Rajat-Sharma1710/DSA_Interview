package com.graphs.bipartite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.graphs.UndirectedGraphsImpl.cyclicBipartite;

public class BipartiteBFS {
    public static void main(String[] args) {
        List<List<Integer>> graph = cyclicBipartite();

        System.out.println(isBipartite(graph));
    }

    private static boolean isBipartite(List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Character[] color = new Character[graph.size()];
        queue.add(1);
        Arrays.fill(color, 'X');
        color[1] = 'R';

        while(!queue.isEmpty()) {
            int ele = queue.poll();

            for(int adj: graph.get(ele)) {
                if(color[adj] == 'X') {
                    queue.add(adj);
                    color[adj] = (color[ele] == 'R') ? 'G' : 'R';
                } else if(color[adj] == color[ele]) {
                    return false;
                }
            }
        }
        return true;
    }
}
