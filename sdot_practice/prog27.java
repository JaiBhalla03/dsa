import java.util.*;

/*Test Case 1
Input:-
3 1,3 2,1 0,0 4,0 5,4 6
2
Output:-
7
Test Case 2
Input:-
0 1,0 2,0 3
5
Output:-
3
* */

public class prog27 {
    public static int ans = 0;
    public static int dfs(int i, List<List<Integer>> adj, int seats, int[] vis){
        vis[i] = 1;
        int persons = 1;
        for(int it : adj.get(i)){
            if(vis[it] == 0){
                persons += dfs(it, adj, seats, vis);
            }
        }
        if(i != 0){
            ans += Math.ceil((double)persons/seats);
        }
        return persons;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] edges = sc.nextLine().split(",");
        int V = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());
        for(String edge : edges){
            int u = Integer.parseInt(Character.toString(edge.charAt(0)));
            int v = Integer.parseInt(Character.toString(edge.charAt(edge.length() - 1)));
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int seats = sc.nextInt();
        int[] vis = new int[V];
        dfs(0, adj, seats, vis);
        System.out.println(ans);
    }
}
