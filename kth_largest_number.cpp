class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        std::sort(nums.begin(), nums.end());
        return nums[nums.size()-k];
    }
};