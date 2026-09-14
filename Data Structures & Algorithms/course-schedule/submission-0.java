class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i< numCourses; i++) {
            map.put(i, new ArrayList<>());
        }    

        for(int[] pts: prerequisites) {
            map.get(pts[0]).add(pts[1]);
        }

        for(int i=0; i<numCourses; i++) {
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

        if(map.get(i).size() == 0) {
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
