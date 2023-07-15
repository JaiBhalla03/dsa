class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;
        vector<int> result;
        int i;
        //main logic
        while(top <= bottom && left <= right){
            //left to right
            for(i = left ; i<=right ; i++){
                result.push_back(matrix[top][i]);
            }
            top++;
            //top to bottom
            for(i = top ; i <= bottom ; i++){
                result.push_back(matrix[i][right]);
            }
            right--;
            //right to left
            if(top <= bottom){
                for(i = right ; i >= left ; i--){
                    result.push_back(matrix[bottom][i]);
                }
                bottom--;
            }
            //bottom to top
            if(left <= right){
                for(i = bottom ; i>=top ; i--){
                    result.push_back(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
};