class Solution {
    public int helper(int i, int[] dp){
        if(i == 0) return 0;
        if(i == 1 || i == 2) return 1;
        if(dp[i] != -1) return dp[i];
        return dp[i] = helper(i-1, dp) + helper(i-2, dp) + helper(i-3, dp);
    }
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = helper(n, dp);
        return ans;
    }
}