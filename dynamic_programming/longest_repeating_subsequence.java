class Solution
{
    public int helper(String str, int m, int n, int[][] dp){
        if(m == 0 || n == 0) return 0;
        if((str.charAt(m-1) == str.charAt(n-1)) && m != n) {
            return dp[m][n] = 1 + helper(str, m-1, n-1, dp);
        }
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = Math.max(helper(str, m-1, n, dp), helper(str, m, n-1, dp));
    }
    public int LongestRepeatingSubsequence(String str)
    {
        int m = str.length();

        int[][] dp = new int[m+1][m+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = helper(str, m, m, dp);
        return ans;
    }
}