void rotate(vector<vector<int> >& matrix)
{
    int n = matrix.size();
    vector<vector<int>> copy(n, vector<int>(n, 0));
    int k = n-1;
    for(int i = 0  ; i < n ; i++){
        for(int j = 0 ; j < n ;j++){
            copy[i][j] = matrix[j][k];
        }
        k--;
    }
    for(int i = 0  ; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
            matrix[i][j] = copy[i][j];
        }
    }
}