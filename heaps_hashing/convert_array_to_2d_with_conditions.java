class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();

        while(mp.size() != 0){
            //System.out.println(mp.size());
            List<Integer> l = new ArrayList<>();
            List<Integer> toRemove = new ArrayList<>();
            for(Map.Entry<Integer, Integer> e : mp.entrySet()){
                System.out.println(e.getKey() + " " + e.getValue());
                if(e.getValue() == 1){
                    l.add(e.getKey());
                    toRemove.add(e.getKey());
                }
                else{
                    l.add(e.getKey());
                    mp.put(e.getKey(), e.getValue() - 1);
                }
            }
            for(int key : toRemove) mp.remove(key);
            ans.add(l);
        }
        return ans;
    }
}