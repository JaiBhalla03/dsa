class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
        int maxSum = 0;
        for(auto x : accounts){
            int sum = 0;
            for(int i = 0 ; i < x.size() ; i++){
                sum += x[i];
            }
            maxSum = max(maxSum, sum);
        }
        return maxSum;
    }
};