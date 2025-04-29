package com.graphs;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int provinces = findProvinces(isConnected);
        System.out.println(provinces);
    }

    private static int findProvinces(int[][] isConnected) {
        int n = isConnected.length;
        DSU obj = new DSU(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && obj.parent.get(i) != j && obj.parent.get(j) != i){
                    if(isConnected[i][j] == 1) {
                        obj.unionBySize(i, j);
                    }
                }
            }
        }

        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(obj.parent.get(i) == i) provinces++;
        }
        return provinces;
    }
}
