class Solution {
public:
    void helper(vector<int> candidates, vector<vector<int>> &ans, vector<int> temp, int index, int sum, int target){
        if(sum == target){
            ans.push_back(temp);
            return;
        }
        if(index >= candidates.size() || sum > target){
            return;
        }
        for(int i = index ; i < candidates.size() ; i++){
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.push_back(candidates[i]);
            helper(candidates, ans, temp, i+1, sum + candidates[i], target);
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> temp;
        int sum = 0;
        int index = 0;
        std::sort(candidates.begin(), candidates.end());
        helper(candidates, ans, temp, index, sum , target);
        return ans;
    }
};