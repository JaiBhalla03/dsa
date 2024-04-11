//the recursive approach that has 2^n complexity
class Solution {
public:
    vector<vector<int>> ans;
    void helper(vector<int> arr, vector<int> temp, int i){
        if(i == arr.size()){
            ans.push_back(temp);
            return;
        }
        temp.push_back(arr[i]);
        helper(arr, temp, i+1);
        temp.pop_back();
        helper(arr, temp, i+1);
        return;
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> temp;
        helper(nums, temp , 0);
        return ans;
    }
};

//using dynamic programming n^2 complexity
class Solution {
public:
    long decimalToBinary(int n){
        long ans = 0;
        long power = 1;
        while(n != 0){
            int r = n%2;
            n /= 2;
            ans += r*power;
            power*=10;
        }
        return ans;
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        //find the total number of subset
        vector<vector<int>> ans;
        vector<int> temp;
        int subset = pow(2, nums.size());
        for(int i = 0 ; i<subset ; i++){
            long bn = decimalToBinary(i);

            int div = pow(10, nums.size()-1);
            for(int j = 0 ; j < nums.size() ; j++){
                long q = bn/div;
                long r = bn%div;
                if(q == 1){
                    temp.push_back(nums[j]);
                }
                bn = r;
                div/=10;
            }
            ans.push_back(temp);
            temp.clear();
        }
        return ans;
    }
};