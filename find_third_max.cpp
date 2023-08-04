//brute for approach
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        set<int> myset(nums.begin(), nums.end());
        vector<int> myvector(myset.begin(), myset.end());
        nums = myvector;
        if(nums.size() < 3){
            return nums[nums.size()-1];
        }
        else{
            return nums[nums.size()-3];
        }
    }
};

//efficients approach
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        set<int> myset(nums.begin(), nums.end());
        vector<int> nums1(myset.begin(), myset.end());
        nums = nums1;
        int n = nums.size();
        if(n == 1) return nums[0];
        if(n == 2) return (nums[0] > nums[1]) ? nums[0] : nums[1];
        int first = INT_MIN, second = INT_MIN, third = INT_MIN;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
            }
            else if(nums[i] > second && nums[i] < first){
                third = second;
                second = nums[i];
            }
            else if(nums[i] > third && nums[i] < second){
                third = nums[i];
            }
        }
        return third;
    }
};

