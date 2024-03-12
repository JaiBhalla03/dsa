class Solution {
    public int helper(List<Integer> nums){
        int n = nums.size();
        int prev1 = nums.get(0);
        int prev2 = 0;
        for(int i = 1 ; i<n ; i++){
            int take = nums.get(i);
            if(i > 1) take += prev2;
            int notTake = prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(i!=0){
                temp1.add(nums[i]);
            }
            if(i != n-1){
                temp2.add(nums[i]);
            }
        }
        return Math.max(helper(temp1), helper(temp2));
    }
}