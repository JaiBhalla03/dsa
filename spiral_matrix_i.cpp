class Solution
{
public:
    //Function to return a list of integers denoting spiral traversal of matrix.
    vector<int> spirallyTraverse(vector<vector<int> > matrix, int r, int c)
    {
        int left = 0, right = c - 1, top = 0, bottom = r-1;
        vector<int> ans;
        while(left <= right && top <= bottom){
            //moving to right 
            for(int i = left ; i <= right ; i++){
                ans.push_back(matrix[top][i]);
            }
            top++;
            //moving to bottom
            for(int i = top ; i <= bottom ; i++){
                ans.push_back(matrix[i][right]);
            }
            right--;
            //moving to left
            if(top <= bottom){
                for(int i = right ; i >= left ; i--){
                    ans.push_back(matrix[bottom][i]);
                }
                bottom--;
            }
            //moving to top
            if(left <= right){
                for(int i = bottom ; i >= top ; i--){
                    ans.push_back(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
};