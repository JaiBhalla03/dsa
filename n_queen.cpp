//recursive solution
class Solution {
public:
    vector<vector<string>> ans;
    string s;
    bool isSafe(vector<vector<int>> board, int r, int c, int n){
        //in the vertical
        int i, j;
        for(i = 0 ; i<r ; i++){
            if(board[i][c] == 1) return false;
        }
        // in the left diagonal
        for(i = r-1, j = c-1 ; i>=0 && j>=0 ; i--, j--){
            if(board[i][j] == 1) return false;
        }
        //in the right diagonal
        for(i = r-1, j = c+1 ; i>=0 && j<n; i--, j++){
            if(board[i][j] == 1) return false;
        }
        return true;
    }
    void helper(vector<vector<int>> board, int n, int r){
        if(n == r){
            vector<string> temp;
            for(int i = 0 ; i<n ; i++){
                s = "";
                for(int j  = 0 ; j < n ; j++){
                    if(board[i][j] == 1) s=s+"Q";
                    else s=s+".";
                }
                temp.push_back(s);
            }
            ans.push_back(temp);
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(isSafe(board, r, i , n)){
                board[r][i] = 1;
                helper(board, n, r+1);
                board[r][i] = 0; //backtrack
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<int>> board(n ,vector<int>(n, 0));
        helper(board, n, 0);
        return ans;
    }
};

//dynamic solution once i learn the dynamic solution

