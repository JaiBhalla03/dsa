class Solution {
    public int dfs(int i, int j, int[][] grid, boolean[][] vis){
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        for(int k = 0 ; k < 4 ; k ++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if((newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) == true || grid[newRow][newCol] == 0) count++;
        }
        for(int k = 0 ; k < 4 ; k++){
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && vis[newRow][newCol] == false && grid[newRow][newCol] == 1){
                count += dfs(newRow, newCol, grid, vis);
            }
        }
        return count;
    }
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    int count = dfs(i, j, grid, vis);
                    return count;
                }
            }
        }
        return -1;
    }
}