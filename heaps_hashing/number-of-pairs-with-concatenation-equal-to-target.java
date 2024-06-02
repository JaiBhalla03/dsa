class Solution {
    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        Map<String, Integer> mp = new HashMap<>();
        int t = target.length();
        for(String num : nums){
            int n = num.length();
            if(target.startsWith(num)){
                ans += mp.getOrDefault(target.substring(n), 0);
            }
            if(target.endsWith(num)){
                ans += mp.getOrDefault(target.substring(0, t-n), 0);
            }
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}