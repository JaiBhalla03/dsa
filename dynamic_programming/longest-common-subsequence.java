class Solution {
    public int helper(String text1, String text2, int m, int n, int[][] dp){
        if(m == 0 || n == 0) return 0;
        if(text1.charAt(m-1) == text2.charAt(n-1)){
            return 1 + helper(text1, text2, m-1, n-1, dp);
        }
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = Math.max(helper(text1, text2, m-1, n, dp), helper(text1, text2, m, n-1, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int x[] : dp){
            Arrays.fill(x, -1);
        }
        int ans = helper(text1, text2, m, n, dp);
        return ans;
    }
}