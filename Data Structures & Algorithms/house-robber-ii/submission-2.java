class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int[] a = new int[nums.length - 1];
        int[] b = new int[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            a[i - 1] = nums[i - 1];
            b[i - 1] = nums[i];
        }

        return Math.max(find(a), find(b));
    }

    public int find(int[] n) {
        if (n.length <= 1) {
            return n[0];
        }
        int[] dp = new int[n.length];
        dp[0] = n[0];
        dp[1] = Math.max(n[1], n[0]);

        for (int i = 2; i < n.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + n[i]);
        }
        return dp[n.length - 1];
    }
}