class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        std::vector<int> result;
        //adding the first element 
        result.push_back(nums[0]);
        int n = nums.size();
        int j = 1;
        for(int i=1;i<n;i++){
            if(nums[i] != nums[i-1]){
                result.push_back(nums[i]);
            }
        }
        nums = result;
        return result.size();
    }
};