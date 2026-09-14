class Solution {
    int[] parent;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
        Arrays.fill(rank, 1);

        int res = n;
        for (int[] edge : edges) {
            res -= union(edge[0], edge[1]);
        }
        return res;
    }

    public int find(int res) {
        while (res != parent[res]) {
            res = parent[res];
        }
        return res;
    }

    public int union(int a, int b) {
        int n1 = find(a);
        int n2 = find(b);

        if (n1 == n2)
            return 0;

        if (rank[n2] > rank[n1]) {
            parent[n1] = n2;
            rank[n2] = 1 + rank[n1];
        } else {
            parent[n2] = n1;
            rank[n1] = 1 + rank[n2];
        }
        return 1;
    }
}
