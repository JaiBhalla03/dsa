class Solution {
    public int helper(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return (int)(1e9); //if the points is not valid return a values that is so large that it wont be take
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + helper(i-1, j, grid, dp);
        int left = grid[i][j] + helper(i, j-1, grid, dp);
        return dp[i][j] = Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        int sum1 = 0, sum2 = 0;
        for(int i = 0 ; i < m ; i++){
            sum1 += grid[i][0];
            dp[i][0] = sum1;
        }
        for(int j = 0 ; j < n ; j++){
            sum2 += grid[0][j];
            dp[0][j] = sum2;
        }
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                int up = 0, left = 0;
                up = grid[i][j] + dp[i-1][j];
                left = grid[i][j] + dp[i][j-1];
                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[m-1][n-1];
    }
}