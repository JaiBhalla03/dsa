import java.util.*;

/*
* 1 bfs (DONE)
* 2 dfs (DONE)
* 3 flood fill (DONE)
* 4 number of triangles (DONE)
* 5 detect a cycle in directed graph (DONE)
* 6 detect a cycle in undirected graph (DONE)
* 7 rate in maze (DONE)
* 8 steps by knight (DONE)
* 9 clone graph
* 10 minimum number of operation to make the graph connected
* 11 topological sort (DONE)
* 12 dijkstra's algo
* 13 number of islands
* */

class graph{
    //helper function to get the adj list (for directed)
    public static List<List<Integer>> getList(int V, String[] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(String edge : edges){
            String[] e = edge.split(",");
            int u = Integer.parseInt(e[0]);
            int v = Integer.parseInt(e[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    public static List<List<Integer>> getList1(int V, String[] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(String edge : edges){
            String[] e = edge.split(",");
            int u = Integer.parseInt(e[0]);
            int v = Integer.parseInt(e[1]);
            adj.get(u).add(v);
        }
        return adj;
    }

    //helper function to get the adjacency matrix
    public static int[][] getMatrix(int V, String[] edges){
        int[][] ans = new int[V][V];
        for(String edge : edges){
            String[] e = edge.split(",");
            int u = Integer.parseInt(e[0]);
            int v = Integer.parseInt(e[1]);
            ans[u][v] = 1;
            ans[v][u] = 1;
        }
        return ans;
    }


    //function for traversing the node using bfs traversal
    public static void bfs(int src, List<List<Integer>> adj){
        boolean[] vis = new boolean[adj.size()];
        vis[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for(int it : adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        System.out.println();
    }

    //function to traversing the graph using the dfs traversal
    public static void dfs(int src, List<List<Integer>> adj, boolean[] vis){
        System.out.print(src + " ");
        vis[src] = true;
        for(int it : adj.get(src)){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }

    //number of triangles
    public static int numberOfTriangle(int[][] mat){
        int ans = 0;
        int n = mat.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    if(mat[i][j] == 1 && mat[j][k] == 1 && mat[k][i] == 1 && i != j && j != k && k != i){
                        ans++;
                    }
                }
            }
        }
        return ans/6;
    }

    //flood fill
    public static void floodfill(int[][] image, int row, int col, int iniColor, int newColor, int[] delRow, int[] delCol, boolean[][] vis){
        vis[row][col] = true;
        image[row][col] = newColor;
        int m = image.length;
        int n = image[0].length;
        for(int i = 0 ; i < 4 ; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !vis[nRow][nCol] && image[nRow][nCol] == iniColor){
                floodfill(image, nRow, nCol, iniColor, newColor, delRow, delCol, vis);
            }
        }
    }

    //detecting a cycle in a directed graph
    public static boolean detectCycle(int src, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[src] = true;
        pathVis[src] = true;
        for(int it : adj.get(src)){
            if(!vis[it]) {
                if(detectCycle(it, adj, vis, pathVis)) return true;
            }
            else if(pathVis[it]) return true;
        }
        return false;
    }

    //detecting a cycle in the undirected graph
    public static boolean helper(int src, List<List<Integer>> adj){
        boolean[] vis = new boolean[adj.size()];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});
        vis[src] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] p = q.poll();
                int node = p[0];
                int parent = p[1];
                for(int it : adj.get(node)){
                    if(!vis[it]){
                        vis[it] = true;
                        q.add(new int[]{it, node});
                    }
                    else if(it != parent){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //function to solve rat in a maze
    public static void solve(int[][] mat, boolean[][] vis, int row, int col, List<String> moves, String s){
        int N = mat.length;
        if(row < 0 || col < 0 || row >= N || col >= N || mat[row][col] == 0 || vis[row][col]) return;
        if(row == N-1 && col == N-1){
            moves.add(s);
        }
        vis[row][col] = true;
        solve(mat, vis, row - 1, col, moves, s + "U");
        solve(mat, vis, row, col + 1, moves, s + "R");
        solve(mat, vis, row + 1, col, moves, s + "D");
        solve(mat, vis, row, col - 1, moves, s + "L");
        vis[row][col] = false;
    }

    //function to solve the steps by knight
    public static int stepsByKnight(int iRow, int iCol, int tRow, int tCol){
        int steps = 0;
        int[] delRow = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] delCol = {-1, 1, 2, 2, 1, -1, -2, -2};
        boolean[][] vis = new boolean[8][8];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{iRow, iCol});
        vis[iRow][iCol] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] p = q.poll();
                if(p[0] == tRow && p[1] == tCol) return steps;
                for(int move = 0 ; move < 8 ; move++){
                    int nRow = delRow[move] + p[0];
                    int nCol = delCol[move] + p[1];
                    if(nRow > 0 && nRow < 8 && nCol > 0 && nCol < 8 && !vis[nRow][nCol]){
                        vis[nRow][nCol] = true;
                        q.add(new int[]{nRow, nCol});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    //function for the topological sort
    public static void topological(int src, List<List<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[src] = true;
        for(int it : adj.get(src)){
            if(!vis[it]) topological(it, adj, vis, st);
        }
        st.push(src);
    }
    //function for the number of islands
    public static void numberOfIslands(int[][] grid, boolean[][] vis, int row, int col){
        vis[row][col] = true;
        int[] delRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delCol = {0, 1, 1, 1, 0, -1, -1, -1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int[] p = q.poll();
                for(int direction = 0 ; direction < 8 ; direction++){
                    int nRow = p[0] + delRow[direction];
                    int nCol = p[1] + delCol[direction];
                    if(nRow >= 0 && nRow < 5 && nCol >= 0 && nCol < 5 && !vis[nRow][nCol] && grid[nRow][nCol] == 1){
                        vis[nRow][nCol] = true;
                        q.add(new int[]{nRow, nCol});
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        System.out.print("Enter the number of vertex: ");
//        int V = sc.nextInt();
//        String[] edges = str.split(" ");
//        List<List<Integer>> adj = getList1(V, edges);
//
        int num = 0;
        int[][] grid = new int[5][5];
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        boolean[][] vis = new boolean[5][5];
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    numberOfIslands(grid, vis, i, j);
                    num++;
                }
            }
        }
        System.out.print("NUMBER OF ISLANDS: " + num);

    }
}