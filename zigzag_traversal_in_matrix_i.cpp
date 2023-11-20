class Solution{
public:
    vector<int> matrixDiagonally(vector<vector<int>>&mat)
    {
        int n = mat.size();
        vector<int> arr(n*n, 0);
        int row = 0, col = 0, i = 0;
        bool up = true;
        while(row < n && col < n){
            if(up){
                while(row > 0 && col < n-1){
                    arr[i++] = mat[row][col];
                    row--; col++;
                }
                arr[i++] = mat[row][col];
                if(col == n-1){
                    row++;
                }
                else{
                    col++;
                }
            }
            else{
                while(col > 0 && row < n-1){
                    arr[i++] = mat[row][col];
                    row++;
                    col--;
                }
                arr[i++] = mat[row][col];
                if(row == n-1){
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