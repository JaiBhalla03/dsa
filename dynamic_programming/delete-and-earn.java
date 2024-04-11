//using memoization one and only solution

class Solution {
    public int helper(int i, List<Integer> num, HashMap<Integer,Integer> map, int[] dp){
        if(i >= num.size()){
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int n = num.get(i);
        int notTake = 0 + helper(i + 1, num, map, dp);
        int take = 0;
        if(map.getOrDefault(n+1,0)==0){
            take=n*map.get(n) + helper(i+1, num, map, dp);
        }
        else{
            take=n*map.get(n) + helper(i+2, num, map, dp);
        }
        return dp[i] = Math.max(notTake, take);
    }
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //
        for(int x : nums){
            int n = map.getOrDefault(x, 0);
            map.put(x, n+1);
        }
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> num = new ArrayList<>();
        num.add(nums[0]);
        for(int i = 1 ; i < n ; i++){
            if(nums[i-1] == nums[i]) continue;
            else{
                num.add(nums[i]);
            }
        }
        int[] dp = new int[num.size() + 1];
        Arrays.fill(dp, -1);
        int ans = helper(0, num, map, dp);
        return ans;
    }
}