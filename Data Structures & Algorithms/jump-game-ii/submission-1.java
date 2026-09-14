class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        int jumps = 0, coverage = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, nums[i] + i);
            if (i == end) {
                end = coverage;
                jumps++;
                if (end >= nums.length - 1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }
}
