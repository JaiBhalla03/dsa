class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = (int)(1e9);
        int l = 0;
        int r = k-1;
        int n = nums.length;
        while(r < n){
            ans = Math.min(ans, Math.abs(nums[l] - nums[r]));
            l++;
            r++;
        }
        return ans;
    }
}