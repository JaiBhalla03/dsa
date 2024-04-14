class Solution {
    public int dfs(int[][] grid, boolean[][] vis, int i, int j){
        int x = 0;
        vis[i][j] = true;

        int m = grid.length;
        int n = grid[0].length;
        if(i == 0 || j == 0 || i == m-1 || j == n-1) x = 1;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int k = 0 ; k < 4 ; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && vis[newRow][newCol] == false && grid[newRow][newCol] == 0){
                vis[newRow][newCol] = true;
                x |= dfs(grid, vis, newRow, newCol);
            }
        }
        return x;
    }
    public int closedIsland(int[][] grid) {
        /**
         0 -> lands
         1 -> water

         use the dfs algorithm
         */
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        int x = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0 && vis[i][j] == false){
                    ans += 1;
                    x = dfs(grid, vis, i, j);
                    if(x == 1) ans -= 1;
                }
            }
        }
        return ans;
    }
}