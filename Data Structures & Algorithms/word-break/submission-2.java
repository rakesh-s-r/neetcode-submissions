class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxL = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            maxL = Math.max(maxL, wordDict.get(i).length());
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i=1; i<=n; i++) {
            for(int j=i-1; j >= Math.max(0, i-maxL); j--) {
                System.out.println(i +" -> "+s.substring(j, i));
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
