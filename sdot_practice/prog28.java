import java.util.*;

/*
Input:-
5
4
1 0
2 1
3 2
4 3
Output:-
1
Test Case 2
Input:-
4
3
1 2
2 3
3 1
Output:-
0
*/

public class prog28 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < E ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0 ; i < V ; i++){
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        boolean ans = topo.size() == V;
        System.out.println(ans);
    }
}
