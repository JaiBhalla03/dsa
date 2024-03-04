import java.util.*;

class Solution {
    // Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        int steps = 0;

        // Adjust positions to 0-based indexing.
        int startX = KnightPos[0] - 1;
        int startY = KnightPos[1] - 1;
        int targetX = TargetPos[0] - 1;
        int targetY = TargetPos[1] - 1;

        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];

                if (x == targetX && y == targetY) {
                    return steps;
                }

                // Explore all possible moves.
                for (int[] move : moves) {
                    int newX = x + move[0];
                    int newY = y + move[1];

                    // Check if the new position is valid and not visited.
                    if (newX >= 0 && newX < N && newY >= 0 && newY < N && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++; // Increment steps after exploring all positions at the current level.
        }

        return -1; // Return -1 if target position cannot be reached.
    }
}
