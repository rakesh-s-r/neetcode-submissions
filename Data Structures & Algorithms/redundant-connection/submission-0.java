class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }
        return new int[] {};
    }

    public int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public void union(int i, int j) {
        int findI = find(i);
        int findJ = find(j);
        if (findI != findJ) {
            parent[findJ] = findI;
        }
    }
}
