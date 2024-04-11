class Solution {

    public static int [] minimumTime(int n,int m, int[][] edges) {
        int[] ans = new int[n];
        //first creating the adjacancy list  from the edges
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            adj.get(x).add(y);

        }
        //finding the indegree
        int[] inDegree = new int[n];

        for(int i = 0 ; i < n ; i++) inDegree[i] = 0;

        for(int i = 0 ; i < n ; i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        int time = 1;


        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int front = q.poll();
                ans[front] = time;
                for(int it : adj.get(front)){
                    inDegree[it]--;
                    if(inDegree[it] == 0) q.add(it);
                }
            }
            time++;
        }
        return ans;
    }
}