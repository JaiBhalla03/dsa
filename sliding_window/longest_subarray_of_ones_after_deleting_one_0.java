class Solution {
    public int longestSubarray(int[] nums) {
        boolean flag = false;
        for(int x : nums){
            if(x == 0) flag = true;
        }
        if(!flag) return nums.length - 1;
        //just find the longest subarray that contains only one 0
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int n = nums.length;
        int count = 0;
        while(r < n){
            if(nums[r] == 0) count++;
            if(count > 1){
                if(nums[l] == 0) count--;
                l++;
            }
            if(count == 1){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen - 1;
    }
}