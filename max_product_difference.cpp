class Solution {
public:
    int maxProductDifference(vector<int>& nums) {
        int n = nums.size();
        std::sort(nums.begin() , nums.end());
        int minProduct = nums[0]*nums[1];
        int maxProduct = nums[n-2]*nums[n-1];
        return maxProduct - minProduct;
    }
};