class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> set = new HashSet<>();
        for(int[] tri: triplets) {
            if(tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2]) {
                continue;
            }
            for(int i=0; i< target.length; i++) {
                if(target[i] == tri[i]) {
                    set.add(i);
                }
            }
        }
        return set.size() == target.length;
    }
}
