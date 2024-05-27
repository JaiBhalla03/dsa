class Solution {
    public int snakesAndLadders(int[][] board) {
        int rows = board.length;
        int minSteps = 0;
        int start = 1;
        int end = rows*rows;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[][] visited = new boolean[rows][rows];
        visited[rows-1][0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int currentPosition = q.poll();
                if(currentPosition == end) return minSteps;
                for(int dice = 1 ; dice <= 6 ; dice++){
                    if(currentPosition + dice > end) break;
                    int[] nextPosition = findCoordinates(currentPosition + dice, rows);
                    int nextRow = nextPosition[0];
                    int nextCol = nextPosition[1];
                    if(visited[nextRow][nextCol] != true){
                        visited[nextRow][nextCol] = true;
                        if(board[nextRow][nextCol] != -1){
                            q.add(board[nextRow][nextCol]);
                        }
                        else q.add(currentPosition + dice);
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }
    public int[] findCoordinates(int currentPosition, int n){
        int r = (currentPosition - 1)/n;
        int c = (currentPosition-1)%n;
        if(r%2 == 0) return new int[]{n-1-r, c};
        return new int[]{n-1-r,n-1-c};
    }
}