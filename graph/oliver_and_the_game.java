import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static int timer = 1;

    public static void dfs(int src, int parent, List<List<Integer>> adj, int[] inTime, int[] outTime){
        inTime[src] = timer++;
        for(int it : adj.get(src)){
            if(it != parent){
                dfs(it, src, adj, inTime, outTime);
            }
        }
        outTime[src] = timer++;
    }

    public static boolean check(int x, int y, int[] inTime, int[] outTime){
        return (inTime[x] > inTime[y]) && (outTime[x] < outTime[y]);
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        int[] inTime = new int[n+1];
        int[] outTime = new int[n+1];

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n-1 ; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        dfs(0, -1, adj, inTime, outTime);
        int q = sc.nextInt();
        for(int i = 0 ; i < q ; i++){
            int type = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if(!check(y, x, inTime, outTime) && !check(x, y, inTime, outTime))
            {
                System.out.println("NO");
                continue;
            }
            if(type == 0){
                if(check(y, x, inTime, outTime)) System.out.println("YES");
                else System.out.println("NO");
            }
            else if(type == 1){
                if(check(x, y, inTime, outTime)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
