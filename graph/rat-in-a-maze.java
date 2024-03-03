class Solution {
    public static void dfs(int i, int j, int[][] vis, int[][] m, int n, String s, ArrayList<String> ans){
        if(i < 0 || j < 0 || i >= n || j >= n) return;
        if(m[i][j] == 0 || vis[i][j] == 1) return;
        if(i == n-1 && j == n-1){
            ans.add(s);
            return;
        }
        vis[i][j] = 1;
        dfs(i-1, j, vis, m, n, s+"U", ans); // moving up
        dfs(i+1, j, vis, m, n, s+"D", ans); // moving down
        dfs(i, j-1, vis, m, n, s+"L", ans); // moving left
        dfs(i, j+1, vis, m, n, s+"R", ans); // moving right
        //backtracking
        vis[i][j] = 0;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];
        if(m[0][0] == 0 || m[n-1][n-1] == 0) return ans;
        String s = "";
        dfs(0, 0, vis, m, n, s, ans);
        Collections.sort(ans);
        return ans;
    }
}