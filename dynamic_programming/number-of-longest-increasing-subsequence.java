class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int i = 0 ; i < n ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i]){
                    cnt[i] = cnt[prev];
                    dp[i] = 1 + dp[prev];
                }
                else if(nums[prev] < nums[i] && 1 + dp[prev] == dp[i]){
                    cnt[i] += cnt[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int nos = 0;
        for(int i = 0 ; i < n ; i++){
            if(dp[i] == maxi){
                nos += cnt[i];
            }
        }
        return nos;
    }
}