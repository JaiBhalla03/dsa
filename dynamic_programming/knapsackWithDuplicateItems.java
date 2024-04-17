class Solution{
    static int helper(int class Solution {
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
    }index, int W, int[] val, int[] wt, int[][] dp){
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