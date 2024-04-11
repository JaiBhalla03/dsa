class Solution {
    // Function to find the number of islands.
    public void dfs(int m, int n, int i, int j, char[][] grid, int[][] vis){
        vis[i][j] = 1;
        int[] diffRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] diffCol = {0, 1, 1, 1, 0, -1, -1, -1};
        for(int k = 0 ; k < 8; k++){
            int newRow = i + diffRow[k];
            int newCol = j + diffCol[k];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                    && vis[newRow][newCol] == 0 &&  grid[newRow][newCol] == '1'){
                dfs(m, n, newRow, newCol, grid, vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        //creating the adjencancy list from the grid
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    dfs(m, n, i, j, grid, vis);
                    ans++;
                }
            }
        }
        return ans;
    }
}