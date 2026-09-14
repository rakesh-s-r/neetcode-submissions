class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        int maxL = 0;
        for(String word: wordDict) {
            maxL = Math.max(maxL, word.length());
        }

        for(int i=1; i<=s.length(); i++) {
            for(int j=i-1; j >= Math.max(0, i-maxL); j--) {
                System.out.println(s.substring(j, i));
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
