class Solution{
    static int helper(int[][] M, int row, int col, int n, int m, int[][] dp){
        if(col == m-1 && row >= 0 && row < n) return M[row][col];
        if(col > m || row < 0 || row >= n) return (int)(-1e9);
        if(dp[row][col] != -1) return dp[row][col];
        int right = M[row][col] + helper(M, row, col + 1, n, m, dp);
        int topRight = M[row][col] + helper(M, row - 1, col + 1, n, m, dp);
        int downRight = M[row][col] + helper(M, row + 1, col + 1, n, m, dp);
        return dp[row][col] = Math.max(right, Math.max(topRight, downRight));
    }
    static int maxGold(int n, int m, int M[][])
    {
        int ans = (int)(-1e9);
        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans, helper(M, i, 0, n, m, dp));
        }
        return ans;
    }
}