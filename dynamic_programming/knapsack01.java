//using just the recursion
class Solution
{
    static int helper(int W, int[] wt, int[] val, int i){
        if(i == 0){
            if(wt[0] <= W) return val[0];
            else return 0;
        }
        //not take
        int notTake = 0 + helper(W, wt, val, i-1);
        //take
        int take = Integer.MIN_VALUE;
        if(W >= wt[i]){
            take = val[i] + helper(W-wt[i], wt, val, i-1);
        }
        return Math.max(notTake, take);
    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int ans = helper(W, wt, val, n-1);
        return ans;
    }
}


//using the memoization
class Solution
{
    static int helper(int W, int[] wt, int[] val, int i, int[][] dp){
        if(i == 0){
            if(wt[0] <= W) return val[0];
            else return 0;
        }
        if(dp[i][W] != -1) return dp[i][W];
        //not take
        int notTake = 0 + helper(W, wt, val, i-1, dp);
        //take
        int take = Integer.MIN_VALUE;
        if(W >= wt[i]){
            take = val[i] + helper(W-wt[i], wt, val, i-1, dp);
        }
        return dp[i][W] = Math.max(notTake, take);
    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[n+1][W+1];
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }
        int ans = helper(W, wt, val, n-1, dp);
        return ans;
    }
}

//space optimised way
