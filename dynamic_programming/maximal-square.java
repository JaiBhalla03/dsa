class Solution {
    public int max = 0;
    public int helper(int i, int j, char[][] matrix, int m, int n, int[][] dp){
        if(i >= m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int right = helper(i, j+1, matrix, m, n, dp);
        int down = helper(i+1, j, matrix, m, n, dp);
        int diagonal = helper(i+1, j+1, matrix, m, n, dp);
        int ans = 0;
        if(matrix[i][j] == '1') {
            ans = 1 + Math.min(right, Math.min(down, diagonal));
            max = Math.max(max, ans);
        }
        else return dp[i][j] = 0;
        return dp[i][j] = ans;
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }
        helper(0, 0, matrix, m, n, dp);
        return max*max;
    }
}