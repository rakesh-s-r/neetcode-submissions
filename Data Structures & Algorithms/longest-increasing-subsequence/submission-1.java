class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i=0; i< n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for(int i=0; i<n; i++) {
            if(dp[max] < dp[i]) {
                max = i;
            }
        }
        return dp[max] + 1;
    }
}
