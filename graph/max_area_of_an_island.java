class Solution {
    public int dfs(int[][] grid, boolean[][] vis, int i, int j){
        vis[i][j] = true;
        int x = 0;
        if(grid[i][j] == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        x += 1;
        for(int k = 0 ; k<4 ; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && vis[newRow][newCol] == false){
                x += dfs(grid, vis, newRow, newCol);
            }
        }
        return x;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    int x = dfs(grid, vis, i, j);
                    ans = Math.max(ans, x);
                }
            }
        }
        return ans;
    }
}