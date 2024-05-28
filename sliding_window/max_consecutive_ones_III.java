class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int r = 0;
        int l = 0;
        int len = 0;
        int maxLen = len;
        int n = nums.length;
        while(r < n){
            if(nums[r] == 0){
                count++;
            }
            if(count > k){
                if(nums[l] == 0) count--;
                l++;
            }
            if(count <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}