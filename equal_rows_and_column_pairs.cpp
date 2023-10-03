class Solution {
public:
    bool isEqual(vector<int> a, vector<int> b){
        for(int i = 0 ; i<a.size();  i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
    int equalPairs(vector<vector<int>>& grid) {
        vector<int> colArr;
        int ans = 0;
        int n = grid.size();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                colArr.push_back(grid[j][i]);
            }
            for(int j = 0 ; j < n ; j++){
                if(isEqual(grid[j], colArr)){
                    ans++;
                }
            }
            colArr.clear();
        }
        return ans;
    }
};