class Solution {
    Boolean[][] cache;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) {
            sum+=i;
        }

        if(sum % 2 != 0) {
            return false;
        }

        int target = sum/2;
        cache = new Boolean[nums.length][target+1];
        return dfs(nums, 0, target);
    }

    public boolean dfs(int[] nums, int index, int target) {
        if(index >= nums.length) {
            return false;
        }

        if(cache[index][target] != null) {
            return cache[index][target];
        }
        if(target == 0) {
            return true;
        }

        boolean take = false;
        if(nums[index] <= target) {
            take = dfs(nums, index+1, target-nums[index]);
        }

        boolean notTake = dfs(nums, index+1, target);
        return cache[index][target] = take || notTake;
    }
}
