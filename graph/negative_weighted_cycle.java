class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;

        for (int i = 0; i <= n - 1; i++) {
            for (int it[]  : edges) {
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    if(i == n-1) return 1;
                    dist[v] = dist[u] + wt;
                }
            }
        }

        return 0;
    }
}