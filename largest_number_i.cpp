class Solution {
public:
    static bool myCompare(long long x, long long y){
        string xy = to_string(x) + to_string(y);
        string yx = to_string(y) + to_string(x);
        return xy > yx;
    }
    string largestNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end(), myCompare);
        string s = "";
        if(nums[0] == 0) return "0";
        for(auto x : nums){
            s = s + to_string(x);
        }
        return s;
    }
};