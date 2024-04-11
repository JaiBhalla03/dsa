class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i = 1 ; i < n ; i++){
            int take = 0;
            if(i > 1){
                take = nums[i] + prev2;
            }
            else{
                take = nums[i];
            }
            int notTake = prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}