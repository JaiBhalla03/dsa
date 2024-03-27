//prims algo

import java.util.*;

/*
Example 1
Input
5
0 2 0 6 0
2 0 3 8 5
0 3 0 0 7
6 8 0 0 9
0 5 7 9 0
Output
16

Example 2
Input
5
0 4 2 0 0
4 0 1 3 0
2 1 0 7 2
0 3 7 0 5
0 0 2 5 0
Output
8
* */

public class prog26 {
    static class Pair implements Comparable<Pair>{
        int v;
        int wt;
        Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Pair that){
            return this.wt - that.wt;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int[][] weights = new int[v][v];
        for(int i = 0 ; i < v ; i++){
            for(int j = 0 ; j < v ; j++){
                weights[i][j] = sc.nextInt();
            }
        }
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i<v; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < v ; i++){
            for(int j = 0 ; j < v ; j++){
                if(weights[i][j] != 0){
                    adj.get(i).add(new Pair(j, weights[i][j]));
                    adj.get(j).add(new Pair(i, weights[i][j]));
                }
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] vis = new int[v];
        pq.add(new Pair(0,0));
        int s = 0;
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int V = node.v;
            int wt = node.wt;
            if(vis[V] == 1) continue;
            vis[V]=1;
            s+=wt;
            for(Pair it : adj.get(V)){
                if(vis[it.v] == 0){
                    pq.add(new Pair(it.v, it.wt));
                }
            }
        }
        System.out.println(s);
    }
}
