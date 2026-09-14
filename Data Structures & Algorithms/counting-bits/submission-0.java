class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<= n; i++) {
            int res = i, count = 0;
            while(res!=0) {
                count+=res&1;
                res = res >> 1;
            }
            dp[i] = count;
        }
        return dp;
    }
}
