class Solution {
    public int helper(int[] nums, int k){
        int n = nums.length;
        int sum = 0;
        int l = 0;
        int r = 0;
        int ans = 0;
        while(r < n){
            sum += nums[r]%2;
            while(sum > k){
                sum -= nums[l]%2;
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
}