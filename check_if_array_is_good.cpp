class Solution {
public:
    bool isGood(vector<int>& nums) {
        sort(nums.begin() ,nums.end());
        int n = nums.size();
        if(n == 1 || n == 0){
            return false;
        }
        int i, k = 1;
        for(i = 0 ; i<n-1;i++){
            if(nums[i] != k){
                return false;
            }
            k++;
        }
        return (nums[n-1] == nums[n-2] && (n == 2 || nums[n-2] - nums[n-3] == 1));
    }
};
