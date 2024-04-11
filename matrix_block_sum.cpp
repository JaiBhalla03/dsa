class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
        vector<vector<int>> answer(mat.size(), vector<int>(mat[0].size()));
        for(int i = 0; i < mat.size(); i++) {
            for(int j = 0; j < mat[0].size(); j++) {
                int rowStart = i-k;
                int rowEnd = i+k;
                int colStart = j-k;
                int colEnd = j+k;

                if(rowStart < 0) {
                    rowStart = 0;
                }

                if(rowEnd >= mat.size()) {
                    rowEnd = mat.size() - 1;
                }

                if(colStart < 0) {
                    colStart = 0;
                }

                if(colEnd >= mat[0].size()) {
                    colEnd = mat[0].size() - 1;
                }

                answer[i][j] = blockSum(mat, rowStart, rowEnd, colStart, colEnd);
            }
        }

        return answer;
    }
    int blockSum(vector<vector<int>>& mat, int rowStart, int rowEnd, int colStart, int colEnd) {
        int sum = 0;

        for(int i = rowStart; i <= rowEnd; i++) {
            for(int j = colStart; j <= colEnd; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }
};