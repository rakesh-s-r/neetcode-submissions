class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = 1, min = 1;

        for(int i=0; i< nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * min));
            res = Math.max(res, max);
        }
        return res;
    }
}
