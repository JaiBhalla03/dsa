class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n = nums.size();
        int count = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == val){
                count++;
            }
        }
        std:: vector<int> ans(n-count);
        int j=0;
        for(int i = 0;i<n;i++){
            if(nums[i] != val){
                ans[j] = nums[i];
                j++;
            }
        }
        nums = ans;
        return n-count;
    }
};