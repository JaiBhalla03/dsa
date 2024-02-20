class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int count[] = new int[n+1];
        for(int i = 0 ; i < n ;i++){
            count[nums[i]] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            if(count[i] < 1) return i;
        }
        return n;
    }
}