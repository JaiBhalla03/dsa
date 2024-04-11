class Solution {
public:
    int findLen(int x){
        int count = 0;
        if(x == 0){
            return 1;
        }
        if(x < 0){
            x*=-1;
            count++;
        }
        while(x!=0){
            x/=10;
            count++;
        }
        return count;
    }
    vector<int> findColumnWidth(vector<vector<int>>& grid) {
        vector<int> result;
        int maxi;
        for(int i = 0 ; i<grid[0].size(); i++){
            maxi = 0;
            for(int j = 0; j<grid.size(); j++){
                maxi = max(maxi, findLen(grid[j][i]));
            }
            result.push_back(maxi);
        }
        return result;
    }
};