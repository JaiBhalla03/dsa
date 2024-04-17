class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            for(String w : wordDict){
                if((i + w.length()) <= s.length() &&
                        s.substring(i, i + w.length()).equals(w)){
                    dp[i] = dp[i + w.length()] || dp[i];
                }
                if(dp[i] == true) break;
            }
        }
        return dp[0];
    }
}