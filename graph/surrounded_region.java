class Solution {
    public void dfs(int i, int j, boolean[][] vis, char[][] board){
        int m = board.length;
        int n = board[0].length;
        vis[i][j] = true; // Mark the cell as visited
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int k = 0 ; k < 4 ; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newCol >= 0 && newCol < n && newRow < m && !vis[newRow][newCol] && board[newRow][newCol] == 'O'){
                dfs(newRow, newCol, vis, board);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n]; // Initialize a boolean array to track visited cells

        // Traverse the boundary and mark connected 'O's as visited
        for(int i = 0 ; i < m ; i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs(i , 0 , vis, board);
            }
            if(board[i][n-1] == 'O' && !vis[i][n-1]){
                dfs(i , n-1 , vis, board);
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(board[0][i] == 'O' && !vis[0][i]){
                dfs(0 , i , vis, board);
            }
            if(board[m-1][i] == 'O' && !vis[m-1][i]){
                dfs(m-1, i, vis, board);
            }
        }


        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
