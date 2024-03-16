class Solution {
    public int helper(int[] cost, int i, int[] dp){
        if(i < 0) return 0;
        if(i == 0) return cost[0];
        if(dp[i] != -1) return dp[i];
        int step1 = cost[i] + helper(cost, i-1, dp);
        int step2 = cost[i] + helper(cost, i-2, dp);
        return dp[i] = Math.min(step1, step2);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dup[] = new int[n+1];
        for(int i = 0 ; i < n ; i++) dup[i] = cost[i];
        dup[n] = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(dup, n, dp);
    }
}