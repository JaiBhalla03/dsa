class Solution {
public:
    int arrayPairSum(vector<int>& nums) {
        //sorting the array 
        std::sort(nums.begin(), nums.end());
        int minMaxSum = 0;
        for(int i = 0 ; i <= nums.size()-2 ; i+=2){
            minMaxSum+=nums[i];
        }
        return minMaxSum;
    }
};