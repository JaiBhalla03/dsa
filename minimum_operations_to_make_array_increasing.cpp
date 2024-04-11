class Solution {
public:
    int minOperations(vector<int>& nums) {
        int n = nums.size();
        if(n == 0 || n == 1) return 0;
        int operations = 0;
        for(int i = 0 ; i<n-1 ; i++){
            if(nums[i+1] > nums[i]) continue;
            operations += nums[i] - nums[i+1] + 1;
            nums[i+1] += nums[i] - nums[i+1] + 1;
        }
        return operations;
    }
};