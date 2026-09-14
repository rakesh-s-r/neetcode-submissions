class Solution {
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int n, int[][] prerequisites) {

        for(int i=0;i<n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] pts: prerequisites) {
            map.get(pts[0]).add(pts[1]);
        }

        for(int i=0; i<n; i++) {
            if(!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i) {
        if(set.contains(i)) {
            return false;
        }
        if(map.get(i).isEmpty()) {
            return true;
        }
        set.add(i);
        for(int j: map.get(i)) {
            if(!dfs(j)) {
                return false;
            }
        }
        set.remove(i);
        map.get(i).clear();
        return true;
    }
}
