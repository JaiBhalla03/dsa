class Solution {
public:
    int sum(vector<int> nums, int start, int end){
        int sum = 0;
        if(end < 0 || start >= nums.size()){
            return sum;
        }
        for(int i = start ; i <= end ; i++){
            sum += nums[i];
        }
        return sum;
    }
    int pivotIndex(vector<int>& nums) {
        int n = nums.size();
        for(int i = 0 ; i < n ; i++){
            if(sum(nums, 0, i-1) == sum(nums, i+1, n-1)){
                return i;
            }
        }
        return -1;
    }
};