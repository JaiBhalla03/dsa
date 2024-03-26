import java.util.*;

public class prog13 {
    public static void dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited){
        visited[i][j] = true;
        int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int[] k : moves){
            int newRow = i + k[0];
            int newCol = j + k[1];
            if(newRow >= 0 && newRow < m && newCol >=0 && newCol < n && grid[newRow][newCol] == 1 && !visited[newRow][newCol]){
                dfs(newRow, newCol, m, n, grid, visited);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int ans = 0; // the following variable stores the number of island in the given graph
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(i, j, m, n, grid, visited);
                    ans++;
                }
            }
        }
        System.out.println("NUMBER OF ISLANDS: " + ans);
    }
}
