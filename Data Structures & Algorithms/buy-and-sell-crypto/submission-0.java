class Solution {
    public int maxProfit(int[] nums) {
        int max = 0;
        int left = 0;
        for(int right = 1; right < nums.length; right ++) {
            if(nums[left] > nums[right]) {
                left = right;
            } else {
                max = Math.max(max, nums[right] - nums[left]);
            }
        }
        return max;
    }
}
