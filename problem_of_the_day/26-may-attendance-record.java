class Solution {
    public int mod = 1000000007;
    public int helper(int n, int cntA, int concL, int[][][] dp){
        if(n == 0) return 1;
        if(dp[n][cntA][concL] != -1) return dp[n][cntA][concL];
        int result = 0;
        //for P
        result = (result + helper(n-1, cntA, 0, dp))%mod;
        //for A
        if(cntA == 0){
            result = (result + helper(n-1, cntA + 1, 0, dp))%mod;
        }
        //for L
        if(concL < 2){
            result = (result + helper(n-1, cntA, concL + 1, dp))%mod;
        }
        return dp[n][cntA][concL] = result;
    }
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j < 2 ; j++){
                for(int k = 0 ; k < 3 ; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int result = helper(n, 0, 0, dp);
        return result;
    }
}