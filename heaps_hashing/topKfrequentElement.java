class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //for solving the following question in O(N) we need to use a hashmap and priority queue
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            pq.add(e);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll().getKey();
        }
        return ans;
    }
}