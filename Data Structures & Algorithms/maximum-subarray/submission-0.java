class Solution {
    public int maxSubArray(int[] nums) {
        int cur_sum = nums[0];
        int sum = nums[0];

        for(int i=1; i< nums.length; i++) {
            cur_sum = Math.max(nums[i], cur_sum + nums[i]);
            sum = Math.max(sum, cur_sum);
        }
        return sum;
    }
}
