class Solution{
    static int helper(int index, int W, int[] val, int[] wt, int[][] dp){
        if(index == 0){
            int a = W/wt[0];
            return val[0]*a;
        }
        if(dp[index][W] != -1){
            return dp[index][W];
        }
        int notTake = helper(index - 1, W, val, wt, dp);
        int take = 0;
        if(wt[index] <= W){
            take = val[index] + helper(index, W - wt[index], val, wt, dp);
        }
        return dp[index][W] = Math.max(take, notTake);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N+1][W+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        int ans = helper(N-1, W, val, wt, dp);
        return ans;
    }
}