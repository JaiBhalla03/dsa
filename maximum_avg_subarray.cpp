class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double currSum = 0.0;
        double currAvg = 0.0;
        for(int i = 0 ; i < k ; i++){
            currSum+=nums[i];
        }
        currAvg = currSum/k;
        for(int i = k ; i < nums.size() ; i++){
            currSum = currSum + nums[i] - nums[i-k];
            double cAvg = currSum/k;
            if(cAvg > currAvg){
                currAvg = cAvg;
            }
        }
        return currAvg;
    }
};