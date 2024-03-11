//memoization
class Solution {
    public int function(int index, int[] dp){
        if(index == 0) return 1;
        if(index == 1) return 1;
        if(dp[index] != -1) return dp[index];
        int left = function(index-1, dp);
        int right = function(index-2, dp);
        return dp[index] = left + right;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            dp[i] = -1;
        }
        return function(n, dp);
    }
}

//tabulation
class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int[] dp = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

//optimized space
class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i = 2 ; i <= n ; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
