class Solution {
    public int maxArea(int[] nums) {
        int left = 0, right = nums.length-1;
        int max = 0;

        while(left <= right) {
            int width = (right - left);
            if(nums[left] <= nums[right]) {
                width*=nums[left];
                left++;
            } else {
                width*=nums[right];
                right--;
            }
            max = Math.max(width, max);
        }
        return max;
    }
}
