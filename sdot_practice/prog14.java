import java.util.*;
/*
Example 2
Input
3 5
1 2 3
Output
1 1 1 1 1
1 1 1 2
1 1 3
1 2 2
2 3
* */

public class prog14 {
    public static void helper(int[] candidates, int index, int currsum, int target, List<List<Integer>> ans , List<Integer> temp){
        if(currsum > target) return;
        if(index == candidates.length){
            if(currsum == target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        //inclusion
        temp.add(candidates[index]);
        currsum += candidates[index];
        helper(candidates, index, currsum, target, ans, temp);
        temp.remove(temp.size() - 1);
        currsum -= candidates[index];
        // exclusion
        helper(candidates, index + 1, currsum, target, ans, temp);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int candidates[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            candidates[i] = sc.nextInt();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, 0, target, ans, temp);
        for(int i = 0 ; i < ans.size() ; i++){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) ->{
            int m = Math.min(o1.size(), o2.size());
            for(int i = 0 ; i < m ; i++){
                if(o1.get(i) == o2.get(i)) continue;
                else return o1.get(i) - o2.get(i);
            }
            return 1;
        });
        for(List<Integer> a : ans){
            for(Integer b : a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
