class Solution{
public :
    vector<vector<int>> ans;
    void helper(vector<int> num, int index){
        if(index == num.size()){
            ans.push_back(num);
            return;
        }
        for(int i = index ; i< num.size() ; i++){
            if(i != index && num[i] == num[index]) continue;
            swap(num[i] , num[index]);
            helper(num , index+1);
        }
    }
    vector<vector<int>> findPermutation(vector<int> nums){
        helper(nums, 0);
        return ans;
    }
};