//memoization
class Solution {
    public int function(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = function(n-1, dp) + function(n-2, dp);
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        for(int i = 0 ; i<=n ; i++){
            dp[i] = -1;
        }
        return function(n, dp);
    }
}

//tabulation
class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

//optimising the space
class Solution {
    public int fib(int n) {
        if(n <= 1) return n;

        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 2 ; i<=n ; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}