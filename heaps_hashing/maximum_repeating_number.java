class Solution {
    int maxRepeating(int[] arr, int n, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int x : arr){
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2)-> (e2.getValue() - e1.getValue()));
        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            pq.add(e);
        }
        int ans = Integer.MAX_VALUE;
        int maxFrequency = pq.peek().getValue();
        while(!pq.isEmpty() && maxFrequency <= pq.peek().getValue()){
            ans = Math.min(ans, pq.poll().getKey());
        }
        return ans;
    }
}