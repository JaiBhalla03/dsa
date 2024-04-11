class Solution {
public:
    int diagonalSum(vector<vector<int>>& mat) {
        int sum_left = 0;
        int sum_right = 0;
        int i, j;
        if(mat.size() == 1){
            return mat[0][0];
        }
        for(i = 0 ; i < mat.size() ; i++){
            for(j = 0 ; j < mat[i].size() ; j++){
                if(i == j){
                    sum_left += mat[i][j];
                }
                if(i + j == mat.size()-1){
                    sum_right += mat[i][j];
                }
            }
        }
        int result = sum_left + sum_right;
        result -= ((mat.size()%2) != 0) ? mat[(mat.size()-1)/2][(mat.size()-1)/2] : 0;
        return result;
    }
};