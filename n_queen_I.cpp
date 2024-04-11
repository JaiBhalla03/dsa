class Solution{
public:
    bool isSafe(vector<vector<int>> board, int r, int c, int n){
        int i, j;
        //checking vertically
        for(i = 0 ; i < r ; i++){
            if(board[i][c] == 1) return false;
        }
        //checking in the left diagonal
        for(i = r - 1, j = c - 1 ; i >=0 && j >= 0 ; i--, j--){
            if(board[i][j] == 1) return false;
        }
        //checking in the right diagonal
        for(i = r -1 , j = c+1 ; i >= 0 && j < n ; i--, j ++){
            if(board[i][j] == 1) return false;
        }
        return true;
    }
    void helper(vector<vector<int>> &board, vector<vector<int>> &ans, int n, int r){
        if(n == r){
            vector<int> t;
            for(int i = 0 ; i < n ; i++){
                int temp = 0;
                for(int j = 0 ; j < n ; j++){
                    if(board[i][j] == 1){
                        temp = j+1; break;
                    }
                }
                t.push_back(temp);
            }
            ans.push_back(t);
            t.clear();
            return;
        }
        for(int i = 0; i < n ; i++){
            if(isSafe(board, r, i, n)){
                board[r][i] = 1;
                helper(board, ans, n, r+1);
                board[r][i] = 0; // backtracking
            }
        }
    }
    vector<vector<int>> nQueen(int n) {
        vector<vector<int>> ans;
        vector<vector<int>> board(n, vector<int>(n, 0));
        helper(board, ans, n, 0);
        return ans;
    }
};