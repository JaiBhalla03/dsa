class Solution {
    static class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public List<Integer> bfs(int i, int j, int[][] land, boolean[][] vis){
        List<Integer> ans = new ArrayList<>();
        ans.add(i);
        ans.add(j);
        int lastRow = 0;
        int lastCol = 0;
        vis[i][j] = true;
        int m = land.length;
        int n = land[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            lastRow = r;
            lastCol = c;
            for(int k = 0 ; k < 4 ; k++){
                int newRow = r + delRow[k];
                int newCol = c + delCol[k];
                if(newRow >= 0 && newRow < m && newCol >=0 && newCol < n && !vis[newRow][newCol] && land[newRow][newCol] == 1){
                    q.add(new Pair(newRow, newCol));
                    vis[newRow][newCol] = true;
                }
            }
        }
        ans.add(lastRow);
        ans.add(lastCol);
        return ans;
    }
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        boolean[][] vis = new boolean[m][n];
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!vis[i][j] && land[i][j] == 1){
                    List<Integer> x = bfs(i, j, land, vis);
                    arr.add(x);
                }
            }
        }
        int[][] result = new int[arr.size()][4];

        for(int i = 0 ; i < arr.size() ; i++){
            for(int j = 0 ; j < arr.get(i).size() ; j++){
                result[i][j] = arr.get(i).get(j);
            }
        }

        return result;
    }
}