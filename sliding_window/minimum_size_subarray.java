class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int n = nums.length;
        boolean flag = false;
        while(r < n){
            sum += nums[r];
            while(sum >= target){
                flag = true;
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return flag ? ans : 0;
    }
}