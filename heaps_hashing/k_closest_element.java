class Solution {
    static class Pair implements Comparable<Pair>{
        int ind;
        int absDiff;
        Pair(int f, int i){
            absDiff = f;
            ind = i;
        }
        public int compareTo(Solution.Pair o){
            if(absDiff == o.absDiff){
                return ind - o.ind;
            }
            else return o.absDiff - absDiff;
        }
    }
    int[] printKClosest(int[] arr, int n, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            int diff = Math.abs(arr[i] - x);
            if(diff != 0){
                pq.add(new Pair(diff, i));
            }
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int j = 0;
        while(!pq.isEmpty()){
            ans[j++] = arr[pq.peek().ind];
            pq.poll();
        }
        j = k-1;
        for(int i = 0 ; i < k/2 ; i++){
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            j--;
        }
        return ans;
    }
}