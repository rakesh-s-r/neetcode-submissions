class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }
        int coverage = 0, end = 0, jumps = 0;
        for(int i=0; i<nums.length; i++) {
            coverage = Math.max(coverage, nums[i] + i);
            if(end == i) {
                jumps++;
                end = coverage;
                if(end >= nums.length-1) {
                    return jumps;
                }
            }
        }
        return jumps;
    }
}
