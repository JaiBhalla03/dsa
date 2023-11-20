class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<bool>> marked(m, vector<bool>(n, false));
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == 0) marked[i][j] = true;
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(marked[i][j]){
                    for(int k = 0 ; k < m ; k++){
                        matrix[k][j] = 0;
                    }
                    for(int k = 0 ; k < n ; k++){
                        matrix[i][k] = 0;
                    }
                }
            }
        }
    }
};