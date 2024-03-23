class Solution {
    public int helper(int i, int amount, int[] coins, int[][] dp){
        if(amount == 0) return 1;
        if(i == coins.length || amount < 0) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int include = helper(i, amount - coins[i], coins, dp);
        int exclude = helper(i+1, amount, coins, dp);
        return dp[i][amount] = include + exclude;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }

        int ans = helper(0, amount, coins, dp);
        return ans;
    }
}