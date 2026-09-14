class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return res;
    }

    public void dfs(int in, int[] nums, List<Integer> cur) {
        if(in >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i< nums.length; i++) {
            if(cur.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            System.out.println(cur);
            dfs(in+1, nums, cur);

            cur.remove(cur.size()-1);
        }
    }
}
