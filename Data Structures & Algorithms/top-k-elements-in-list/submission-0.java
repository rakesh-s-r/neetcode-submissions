class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for(int i=0; i<= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i= bucket.size()-1; i > 0; i--) {
            for(int j: bucket.get(i)) {
                res[idx] = j;
                idx++;
                if(idx == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
