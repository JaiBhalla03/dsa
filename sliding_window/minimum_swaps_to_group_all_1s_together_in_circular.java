class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        for(int x : nums){
            if(x == 1) k++;
        }
        int n = nums.length;
        int l = 0;
        int r = k;
        int ans = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0 ; i < k ; i++){
            if(nums[i] == 0) count++;
        }
        if(r < n){
            while(l < n){
                ans = Math.min(ans, count);
                count = (nums[r] == 0) ? count + 1 : count;
                count = (nums[l] == 0) ? count - 1 : count;
                r = (r + 1)%n;
                l++;
            }
        }
        ans = Math.min(ans, count);
        return ans;
    }
}