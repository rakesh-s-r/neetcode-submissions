class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(0, nums);
        return res;
    }

    public void dfs(int index, int[] nums) {
        if(index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i=0; i< nums.length; i++) {
            if(subset.contains(nums[i])) {
                continue;
            }

            subset.add(nums[i]);
            dfs(index+1, nums);

            subset.remove(subset.size()-1);
        }

    }
}
