class Solution {
    public int helper(int i, int[] coins, int amount, int[][] dp){
        if(amount == 0) return 0;
        if(i == coins.length) return (int)(1e9);
        if(amount < 0) return (int)(1e9);
        if(dp[i][amount] != -1) return dp[i][amount];
        int include = 1 + helper(i, coins, amount - coins[i], dp);
        int exclude = helper(i+1, coins, amount, dp);
        return dp[i][amount] = Math.min(include, exclude);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }
        int ans = helper(0, coins, amount, dp);
        return ans == (int)(1e9) ? -1 : ans;
    }
}