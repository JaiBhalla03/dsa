class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int product = 1;
        int productWith0 = 1;
        vector<int> ans;
        int count = 0;
        for(int i = 0 ; i < nums.size() ; i++){
            product *= nums[i];
            if(nums[i] != 0){
                productWith0 *= nums[i];
            }
            else{
                count++;
            }
        }
        if(count == 1){
            for(int i = 0 ; i<nums.size() ; i++){
                if(nums[i] == 0){
                    ans.push_back(productWith0);
                }
                else{
                    ans.push_back(0);
                }
            }
        }
        else if(count > 1){
            for(int i = 0 ; i < nums.size() ; i++){
                ans.push_back(0);
            }
        }
        else{
            for(int i = 0 ; i< nums.size() ; i++){
                ans.push_back(product/nums[i]);
            }
        }
        return ans;
    }
};