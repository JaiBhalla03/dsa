class Solution {
    public int helper(String s, String r, int m, int n, int[][] dp){
        if(m == 0 || n == 0) return 0;
        if(s.charAt(m-1) == r.charAt(n-1)) return dp[m][n] =  1 + helper(s, r, m-1, n-1, dp);
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = Math.max(helper(s, r, m-1, n, dp) , helper(s, r, m, n-1, dp));
    }
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int[][] dp = new int[m+1][m+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        int ans = helper(s, r, m, m, dp);
        return ans;
    }
}