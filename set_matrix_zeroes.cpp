class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        vector<pair<int, int>> zeroes;
        int m = matrix.size();
        int n = matrix[0].size();
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j < n; j++){
                if(matrix[i][j] == 0){
                    pair<int, int> newPair(i, j);
                    zeroes.push_back(newPair);
                }
            }
        }
        for(int i = 0 ; i < zeroes.size() ; i++){
            for(int j = 0 ; j<n ; j++){
                matrix[zeroes[i].first][j] = 0;
            }
            for(int j = 0 ; j<m ; j++){
                matrix[j][zeroes[i].second] = 0;
            }

        }
    }
};