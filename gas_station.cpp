class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        int total = 0;
        int curr_sum = 0;
        int start = 0;
        for(int i = 0; i<n ;i++){
            curr_sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(curr_sum < 0){
                curr_sum = 0;
                start = i+1;
            }
        }
        return (total < 0) ? -1 : start;
    }
};