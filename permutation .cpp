//brute force approach using recursion
class Solution {
public:
    vector<vector<int>> ans;
    void helper(vector<int> num, int i){
        if(i == num.size()){
            ans.push_back(num);
            return;
        }
        for(int j = i ; j<num.size() ; j++){
            swap(num[i], num[j]);
            helper(num, i+1);
            swap(num[i], num[j]); //backtracking
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        helper(nums, 0);
        return ans;
    }
};

//efficient approach using dp
