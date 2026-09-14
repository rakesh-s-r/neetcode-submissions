class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(left <=  right) {
            if(nums[left] <= nums[right]) {
                min = Math.min(nums[left], min);
                return min;
            }
            int mid = (left+right)/2;
            System.out.println(mid);
            min = Math.min(nums[mid], min);
            if(nums[left] <= nums[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return min;
    }
}
