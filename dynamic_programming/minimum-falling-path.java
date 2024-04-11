class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int k = 0; k < n; k++) {
            dp[0][k] = matrix[0][k];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i][j] + dp[i - 1][j];
                int leftd = (j - 1 >= 0) ? (matrix[i][j] + dp[i - 1][j - 1]) : Integer.MAX_VALUE;
                int rightd = (j + 1 < n) ? (matrix[i][j] + dp[i - 1][j + 1]) : Integer.MAX_VALUE;
                dp[i][j] = Math.min(down, Math.min(leftd, rightd));
            }
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m - 1][i]);
        }
        return ans;
    }
}