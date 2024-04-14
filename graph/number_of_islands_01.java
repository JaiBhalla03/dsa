class Solution {
    public void dfs(char[][] grid, boolean[][] vis, int i, int j){
        vis[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int k = 0 ; k < 4 ; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && vis[newRow][newCol] == false && grid[newRow][newCol] == '1'){
                vis[newRow][newCol] = true;
                dfs(grid, vis, newRow, newCol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    ans++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return ans;
    }
}