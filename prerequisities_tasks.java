class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        //create the adjacancy list from the edges
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : prerequisites){
            int x = edge[0];
            int y = edge[1];
            adj.get(x).add(y);
        }
        //creating the indegree
        int[] inDegree = new int[N];
        for(int i = 0 ; i < N ; i++){
            inDegree[i] = 0;
        }
        for(int i = 0 ; i < N ; i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            if(inDegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int front = q.poll();
                for(int it : adj.get(front)){
                    inDegree[it]--;
                    if(inDegree[it] == 0) q.add(it);
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            if(inDegree[i] != 0) return false;
        }

        return true;
    }

}