class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> result(n, vector<int>(n, 0));
        int left = 0 , top = 0, right = n-1, bottom = n-1;
        int count = 0;
        while(left <= right && top <= bottom){
            for(int i = left ; i <= right ; i++){
                result[top][i] = ++count;
            }
            top++;
            for(int i = top ; i <= bottom ; i++){
                result[i][right] = ++count;
            }
            right--;
            for(int i = right ; i>=left ; i--){
                result[bottom][i] = ++count;
            }
            bottom--;
            for(int i = bottom ; i>=top ; i--){
                result[i][left] = ++count;
            }
            left++;
        }
        return result;
    }
};