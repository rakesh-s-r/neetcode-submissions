class Solution {
    Set<Integer> set = new HashSet<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {
        if(n == 0) {
            return true;
        }

        for(int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && set.size() == n;
    }

    public boolean dfs(int node, int prev) {
        if(set.contains(node)) {
            return false;
        }

        set.add(node);
        for(int j: map.get(node)) {
            if(j == prev) {
                continue;
            }
            if(!dfs(j, node)) {
                return false;
            }
        }
        return true;
    }
}
