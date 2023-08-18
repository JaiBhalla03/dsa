class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> myset(nums.begin(), nums.end());
        return nums.size() != myset.size();
    }
};

//but this solution take extra space

//so just sort the array
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        for(int i = 0 ; i < nums.size()-1 ; i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
};