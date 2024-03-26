class Solution {
    public int longestSubSequences(int[] nums, int index, int prevIndex, int n, int[][] dp){
        if(index == n){
            return 0;
        }
        if(dp[index][prevIndex+1] != -1){
            return dp[index][prevIndex+1];
        }
        int notTake = 0 + longestSubSequences(nums, index + 1, prevIndex, n, dp);
        int take = Integer.MIN_VALUE;
        if(prevIndex == -1 || nums[prevIndex] < nums[index]){
            take = 1 + longestSubSequences(nums, index + 1, index, n, dp);
        }
        return dp[index][prevIndex+1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums.length ; j++){
                dp[i][j] = -1;
            }
        }
        int ans = longestSubSequences(nums, 0, -1, nums.length, dp);
        return ans;
    }
}

//another method
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int i = 0 ; i < n ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}