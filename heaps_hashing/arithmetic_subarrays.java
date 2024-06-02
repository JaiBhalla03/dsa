class Solution {
    public boolean isConsistent(PriorityQueue<Integer> pq){
        if(pq.size() < 3) return true;
        List<Integer> l = new ArrayList<>();
        while(!pq.isEmpty()) l.add(pq.poll());
        int diff = l.get(1) - l.get(0);
        for(int i = 1 ; i < l.size() ; i++){
            int d = l.get(i) - l.get(i-1);
            if(d != diff) return false;
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();
        int n = nums.length;
        int m = l.length;
        for(int i = 0 ; i < m ; i ++){
            int start = l[i];
            int end = r[i];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j = start ; j <= end ; j++){
                pq.add(nums[j]);
            }
            mp.put(i, pq);
        }
        for(int i = 0 ; i < m ; i++){
            if(isConsistent(mp.get(i))) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}