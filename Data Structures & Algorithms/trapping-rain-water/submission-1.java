class Solution {
    public int trap(int[] nums) {
        int left = 0, right = nums.length-1;
        int count = 0;
        int maxL = nums[left], maxR = nums[right];

        while(left <= right) {
            if(maxL <= maxR) {
                maxL = Math.max(maxL, nums[left]);
                count+= maxL - nums[left];
                left++;
            } else {
                maxR = Math.max(maxR, nums[right]);
                count+= maxR - nums[right];
                right--;
            }
        }
        return count;
    }
}
