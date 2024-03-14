class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int ps = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0 ; i < nums.length ; i++){
            ps += nums[i];
            res += map.getOrDefault(ps - goal, 0);
            map.put(ps, map.getOrDefault(ps, 0) + 1);
        }
        return res;
    }
}