class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
        vector<int> row_max(grid.size(), 0);
        vector<int> col_max(grid.size(), 0);
        int i, j;
        //finding the maximum in the rows and in the columns
        for(i = 0 ; i < grid.size() ; i++){
            for(j = 0 ; j<grid[i].size() ; j++){
                row_max[i] = max(row_max[i], grid[i][j]);
                col_max[i] = max(col_max[i], grid[j][i]);
            }
        }
        //finding the result 
        int result = 0;
        for(i = 0 ; i<grid.size() ; i++){
            for(j = 0 ; j<grid[i].size() ; j++){
                result += min(row_max[i], col_max[j]) - grid[i][j];
            }
        }
        return result;
    }
};