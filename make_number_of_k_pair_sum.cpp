class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        int op = 0;
        unordered_map<int, int> numfreq;
        for(int i = 0 ; i < nums.size() ; i++){
            int complement = k - nums[i];
            if(numfreq.find(complement) != numfreq.end() && numfreq[complement] > 0){
                op++;
                numfreq[complement]--;
            }
            else{
                numfreq[nums[i]]++;
            }
        }
        return op;
    }
};