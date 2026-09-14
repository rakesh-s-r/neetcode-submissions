class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return res;    
    }

    public void dfs(int i, int[] nums, List<Integer> cur) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(i+1, nums, cur);

        cur.remove(cur.size()-1);
        dfs(i+1, nums, cur);
    }
}
