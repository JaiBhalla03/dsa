class Solution {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int bfs(int[][] grid, boolean[][] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        vis[0][0] = true;
        int[] delRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delCol = {0, 1, 1, 1, 0, -1, -1, -1};
        int ans = 1;
        int n = grid.length;
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int k = 0 ; k < size ; k++){
                Pair current = q.poll();
                int r = current.row;
                int c = current.col;

                for(int i = 0 ; i < 8 ; i++){
                    int newRow = r + delRow[i];
                    int newCol = c + delCol[i];
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0 && vis[newRow][newCol] == false){
                        q.add(new Pair(newRow, newCol));
                        vis[newRow][newCol] = true;
                    }
                    if(newRow == n-1 && newCol == n-1 && grid[newRow][newCol] == 0) return ans;
                }

            }
        }
        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 1){
            return (grid[0][0] == 0) ? 1 : -1;
        }
        boolean[][] vis = new boolean[n][n];


        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        return bfs(grid, vis);
    }
}