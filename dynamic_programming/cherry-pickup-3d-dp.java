class Solution {
    public int helper(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp){
        if(j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return (int)(-1e9);
        if(i == n-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int maxi = 0;
        for(int dj1 = -1 ; dj1 <= 1 ; dj1++){
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){
                if(j1 == j2){
                    maxi = Math.max(maxi, grid[i][j1] + helper(i+1, j1+dj1, j2+dj2, grid, n, m, dp));
                }
                else{
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + helper(i+1, j1+dj1, j2+dj2, grid, n, m, dp));
                }
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n+1][m+1][m+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                for(int k = 0 ; k <= m ; k++) dp[i][j][k] = -1;
            }
        }
        int ans = helper(0, 0, m-1, grid, n, m, dp);
        return ans;
    }
}