class Solution {
    public static final long MOD = 1000000007;

    public long helper(String str, int i, int j, long[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = (1 + helper(str, i + 1, j, dp) + helper(str, i, j - 1, dp)) % MOD;
        } else {
            dp[i][j] = (helper(str, i + 1, j, dp) + helper(str, i, j - 1, dp) - helper(str, i + 1, j - 1, dp) + MOD) % MOD;
        }
        return dp[i][j];
    }

    long countPS(String str) {
        int n = str.length();
        long[][] dp = new long[n][n];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(str, 0, n - 1, dp);
    }

}