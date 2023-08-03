class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int r = nums.size() - 1;
        int mid = 0;
        while(l <= r){
            mid = l + (r-l)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                l = mid + 1;
            }
            else{
                r = mid -1;
            }
        }
        return -1;
    }
};