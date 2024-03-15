class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int totalWithZero = 1;
        int totalWithoutZero = 1;
        int count0 = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            totalWithZero = totalWithZero*nums[i];
            if(nums[i] == 0) count0++;
            if(nums[i] != 0) totalWithoutZero *= nums[i];
        }
        if(count0 > 1){
            for(int i = 0 ; i < nums.length ; i++){
                ans[i] = 0;
            }
            return ans;
        }
        else{
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i] == 0) ans[i] = totalWithoutZero;
                else ans[i] = totalWithZero/nums[i];
            }
            return ans;
        }
    }
}