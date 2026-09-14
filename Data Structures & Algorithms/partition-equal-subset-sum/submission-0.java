class Solution {
    Boolean[][] cache;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums) {
            sum+=n;
        }

        if(sum%2 != 0) {
            return false;
        }
        int target = sum/2;
        cache = new Boolean[nums.length][target+1];

        return dfs(0, nums, target);
    }

    public boolean dfs(int i, int[] nums, int target) {
        if(target == 0) {
            return true;
        }

        if(i >= nums.length) {
            return false;
        }
        if(cache[i][target] != null) {
            return cache[i][target];
        }

        boolean take = false;
        if(nums[i] <= target) {
            take = dfs(i+1, nums, target-nums[i]);
        }
        boolean notTake = dfs(i+1, nums, target);
        return cache[i][target] = take || notTake;
    }
}
