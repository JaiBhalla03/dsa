//the following approach is brute force now we are going to apply dp to make it efficient

class Solution {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int bfs(int[][] mat, boolean[][] vis,  int i, int j){
        if(mat[i][j] == 0) return 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            for(int k = 0 ; k < size ; k++){
                Pair current = q.poll();
                int r = current.row;
                int c = current.col;
                for(int l = 0 ; l < 4 ; l++){
                    int newRow = r + delRow[l];
                    int newCol = c + delCol[l];
                    if(newCol >= 0 && newCol < n && newRow >= 0 && newRow < m && vis[newRow][newCol] == false){
                        if(mat[newRow][newCol] == 0) return ans;
                        q.add(new Pair(newRow, newCol));
                        vis[newRow][newCol] = true;
                    }
                }
            }
        }
        return -1;
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                boolean[][] vis = new boolean[m][n];
                ans[i][j] = bfs(mat,vis, i, j);

            }
        }
        return ans;
    }
}

//optimised
class Solution {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int[][] ans){
        Queue<Pair> q = new LinkedList<>();
        int m = ans.length;
        int n = ans[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(ans[i][j] == 0) q.add(new Pair(i, j));
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int r = current.row;
            int c = current.col;


            for (int k = 0; k < 4; k++) {
                int newRow = r + delRow[k];
                int newCol = c + delCol[k];


                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && ans[newRow][newCol] == -1) {
                    ans[newRow][newCol] = ans[r][c] + 1;
                    q.offer(new Pair(newRow, newCol));
                }
            }
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                ans[i][j] = ( mat[i][j] == 0 ) ? 0 : -1;
            }
        }

        bfs(ans);
        return ans;
    }
}
