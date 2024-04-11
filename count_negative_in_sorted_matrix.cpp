class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0;
        for(auto x : grid){
            for(int i = x.size()-1 ; i>=0 ;i--){
                if(x[i] < 0) count++;
                else break;
            }
        }
        return count;
    }
};