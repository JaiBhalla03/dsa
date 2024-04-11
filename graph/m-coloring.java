class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean isSafe(boolean graph[][], int i, int j, int[] color, int n){
        for(int k = 0 ; k < n ; k++){
            if(graph[i][k] == true && color[k] == j) return false;
        }
        return true;
    }
    public boolean helper(boolean graph[][], int[] color, int m, int n, int i){
        if(i == n) return true;
        for(int j = 0 ; j < m ; j++){
            if(isSafe(graph, i, j, color, n)){
                color[i] = j;
                if(helper(graph, color, m, n, i+1)) return true;
                color[i] = -1;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        for(int i = 0 ; i < n ; i++) color[i] = -1;
        return helper(graph, color, m, n, 0);
    }
}