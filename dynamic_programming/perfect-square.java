class Solution {
    public int helper(int n, int[] dp){
        if(n <= 0) return 0;
        if(dp[n] != -1) return dp[n];
        int min = (int)(1e9);

        for(int i = 1 ; i <= Math.sqrt(n) ; i++){
            int res = 1 + helper(n-i*i, dp);
            min = Math.min(min, res);
        }
        return dp[n] = min;
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = helper(n, dp);
        return ans;
    }
}