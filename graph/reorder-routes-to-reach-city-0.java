class Solution {
    static class Node{
        int v;
        int w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Node>> adj = new ArrayList<>();
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] connection : connections){
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(new Node(v, 1));
            adj.get(v).add(new Node(u, 0));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(Node next : adj.get(curr)){
                if(visited[next.v] == false){
                    res += next.w;
                    visited[next.v] = true;
                    q.add(next.v);
                }
            }
        }
        return res;
    }
}