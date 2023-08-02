class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        int l, k;
        int n = grid.size();
        std::vector<std::vector<int>> result(n-2, std::vector<int>(n-2,0));
        int maxelement;
        for(l = 0 ; l <= n-3 ; l++){
            for(k = 0 ; k <= n-3 ; k++){
                maxelement = 0;
                for(int i = k ; i < k+3 ; i++){
                    for(int j = l ; j < l+3 ;j++){
                        maxelement = max(maxelement, grid[i][j]);
                    }
                }
                result[k][l] = maxelement;
            }
        }
        return result;
    }
};