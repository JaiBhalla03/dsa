class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisty : prerequisites){
            int u = prerequisty[0];
            int v = prerequisty[1];
            adj.get(u).add(v);

        }
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        if(topo.size() == numCourses) return true;
        return false;
    }
}