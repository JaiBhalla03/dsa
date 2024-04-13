class Solution {
    static long countBT(int h){
        long[] dp = new long[h+1];
        dp[0] = 1;
        dp[1] = 1;
        int mod  = (int)(1e9) + 7;
        for(int i = 2 ; i <= h ; i++){
            dp[i] = (dp[i-1]*dp[i-1] + 2*dp[i-1]*dp[i-2])%mod;
        }
        return dp[h];
    }
}