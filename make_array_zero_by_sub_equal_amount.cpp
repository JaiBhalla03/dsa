class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        unordered_map<int,int> mpp;
        for(int i = 0  ; i <= 100 ; i++){
            mpp[i]=0;
        }
        for(auto x : nums){
            mpp[x] ++;
        }
        int ans = 0;
        for(int i = 1 ; i<= 100 ; i++){
            if(mpp[i] != 0){
                ans++;
            }
        }
        return ans;
    }
};