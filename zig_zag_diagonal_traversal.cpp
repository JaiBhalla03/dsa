class Solution{
public:
    vector<int> matrixDiagonally(vector<vector<int>>&mat)
    {
        int m = mat.size();
        int n = mat[0].size();
        int row = 0;
        int col = 0;
        bool up = true;
        vector<int> arr(m*n, 0);
        int i = 0;
        while(row < n && col < m){
            //when moving up
            if(up){
                while(row > 0 && col < n-1){
                    arr[i++] = mat[row][col];
                    row--;
                    col++;
                }
                arr[i++] = mat[row][col];
                if(col == n-1){
                    row++;
                }
                else{
                    col++;
                }
            }
                //when moving down
            else{
                while(col > 0 && row < m-1){
                    arr[i++] = mat[row][col];
                    row++;
                    col--;
                }
                arr[i++] = mat[row][col];
                if(row == m-1){
                    col++;
                }
                else{
                    row++;
                }
            }
            up = !up;
        }
        return arr;
    }
};
