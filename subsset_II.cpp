class Solution {
public:
    void helper(vector<vector<int>> &ans, vector<int> nums, vector<int> temp, int index){
        if(index == nums.size()){
            ans.push_back(temp);
            return;
        }
        temp.push_back(nums[index]);

        helper(ans, nums, temp, index+1);
        temp.pop_back();
        helper(ans, nums, temp, index+1);
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> temp;
        sort(nums.begin(), nums.end());
        helper(ans, nums, temp, 0);
        set<vector<int>> result(ans.begin(), ans.end());
        vector<vector<int>> result1(result.begin(), result.end());
        return result1;
    }
};