// using memoization

class Solution{
    public static boolean helper(int ind, int[] arr, int sum, int[][] dp){
        if(sum == 0) return true;
        if(ind == 0) return arr[0] == sum;
        if(dp[ind][sum] != -1) return dp[ind][sum] == 1;
        boolean notTake = helper(ind-1, arr, sum, dp);
        boolean take = false;
        if(sum >= arr[ind]) take = helper(ind-1, arr, sum-arr[ind], dp);
        return (dp[ind][sum] = (notTake || take) ? 1 : 0) == 1;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[N+1][sum+1];
        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <= sum ; j++){
                dp[i][j] = -1;
            }
        }
        return helper(N-1, arr, sum, dp);
    }
}

//using tabulation
