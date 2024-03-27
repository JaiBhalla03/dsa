class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int product = 1;
        int count = 0;
        int n = nums.length;
        if(k <= 1) return 0;
        while(right < n){
            product *= nums[right];
            while(product >= k) product /= nums[left++];
            count += 1 + (right - left);
            right ++;
        }
        return count;
    }
}