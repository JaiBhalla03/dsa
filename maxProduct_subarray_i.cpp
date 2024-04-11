class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];
        for(int i = 0 ; i < nums.size() ; i++){
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;
            leftProduct*= nums[i];
            rightProduct*= nums[nums.size() - i - 1];
            ans = max(ans, max(leftProduct, rightProduct));
        }
        return ans;
    }
};