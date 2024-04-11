class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Pair{
        int distance;
        int node;
        Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] dis = new int[V];
        for(int i = 0 ; i < V ; i++) dis[i] = (int)1e9;
        dis[S] = 0;
        pq.add(new Pair(0, S));
        while(pq.size() != 0){
            int dist = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for(int i = 0 ; i < adj.get(node).size() ; i++){
                int adjWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(dist + adjWeight < dis[adjNode]){
                    dis[adjNode] = dist + adjWeight;
                    pq.add(new Pair(dis[adjNode], adjNode));
                }
            }
        }
        return dis;
    }
}