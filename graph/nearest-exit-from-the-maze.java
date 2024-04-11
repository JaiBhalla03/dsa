class Solution {
    static class Pair{
        int r;
        int c;
        Pair(int row, int col){
            this.r = row;
            this.c = col;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = entrance[0];
        int col = entrance[1];
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        int[] rowDel = {-1, 0,1,0};
        int[] colDel = {0, 1,0,-1};
        int ans = 0;
        vis[row][col] = true;
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int j = 0 ; j < size ; j++){
                Pair current = q.poll();
                for(int i = 0 ; i < 4 ; i++){
                    int newR = current.r + rowDel[i];
                    int newC = current.c + colDel[i];
                    if(newR >= 0 && newR < m && newC >= 0 && newC < n && !vis[newR][newC] && maze[newR][newC] == '.'){
                        q.add(new Pair(newR, newC));
                        vis[newR][newC] = true;
                        if(newR == 0 || newC == 0 || newR == m-1 || newC == n-1){
                            return ans;
                        }
                    }
                }
            }
        }
        return -1;
    }
}