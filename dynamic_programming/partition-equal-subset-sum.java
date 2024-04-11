class Solution {
    public boolean helper(int ind, int target, int[] nums, int[][] dp){
        if(target == 0) return true;
        if(ind == 0) return target == nums[0];
        if(dp[ind][target] != -1) return dp[ind][target] == 1;
        boolean notTake = helper(ind-1, target, nums, dp);
        boolean take = false;
        if(target >= nums[ind]){
            take = helper(ind-1, target-nums[ind], nums, dp);
        }
        return (dp[ind][target] = (notTake || take) ? 1 : 0) == 1;
    }
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i = 0 ; i < nums.length ; i++){
            target += nums[i];
        }
        if(target % 2 == 1) return false;
        target /= 2;
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= target ; j++) dp[i][j] = -1;
        }
        return helper(n-1, target, nums, dp);
    }
}