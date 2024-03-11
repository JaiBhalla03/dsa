//the following is the brute force approach

class Solution {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    static class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        //creating the adjencancy list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0 ; i < flights.length ; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        int[] dist = new int[n];
        for(int i = 0 ; i < n ; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        q.add(new Tuple(0, src, 0));
        int steps = 0;
        while(!q.isEmpty()){
            Tuple itr = q.poll();
            int stops = itr.first;
            int node = itr.second;
            int cost = itr.third;
            if(stops > k) continue;
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int adjWt = it.second;
                if(cost + adjWt < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + adjWt;
                    q.add(new Tuple(stops + 1, adjNode, cost + adjWt));
                }
            }
        }
        if(dist[dst] == 1e9) return -1;
        return dist[dst];
    }
}

