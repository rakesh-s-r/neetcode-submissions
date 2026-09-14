class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int maxL = height[left], maxR = height[right];

        int count = 0;
        while(left <= right) {
            if(maxL <= maxR) {
                maxL = Math.max(maxL, height[left]);
                count+=maxL - height[left];
                left++;
            } else {
                maxR = Math.max(maxR, height[right]);
                count+=maxR - height[right];
                right--;
            }
        }
        return count;
    }
}
