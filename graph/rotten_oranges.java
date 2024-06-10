class Solution {
    static class Pair{
        int row;
        int col;
        int tm;
        public Pair(int row, int col, int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int count = 0;
        int tm = 0;
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().tm;
            tm = Math.max(tm, time);
            q.remove();
            for(int i = 0 ; i < 4 ; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && vis[newRow][newCol] == 0){
                    count ++;
                    grid[newRow][newCol] = 2;
                    q.add(new Pair(newRow, newCol, tm + 1));
                }
            }
        }
        if(count != cntFresh) return -1;
        return tm;
    }
}