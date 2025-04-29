package com.graphs.bipartite;

import java.util.Arrays;
import java.util.List;

import static com.graphs.UndirectedGraphsImpl.cyclicBipartite;

public class BipartiteDFS {
    public static void main(String[] args) {
        List<List<Integer>> graph = cyclicBipartite();

        System.out.println(isBipartite(graph));
    }

    private static boolean isBipartite(List<List<Integer>> graph) {
        Character[] color = new Character[graph.size()];
        Arrays.fill(color, 'X');
        return dfsBipartite(graph, 1, 'R', color);
    }

    private static boolean dfsBipartite(List<List<Integer>> graph, int node,Character color,
                                        Character[] colorArray) {
        colorArray[node] = color;
        Character adjColor = (color == 'R') ? 'G' : 'R';
        for(int i = 0; i < graph.get(node).size(); i++) {
            int adjEle = graph.get(node).get(i);
            if(colorArray[adjEle] == 'X') {
                boolean ans = dfsBipartite(graph, adjEle, adjColor, colorArray);
                if(!ans) return false;
            } else if(colorArray[adjEle] == colorArray[node]){
                return false;
            }
        }
        return true;
    }
}
