class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[] hash = new int[2001];
        int k = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(hash[nums[i]] == 0){
                hash[nums[i]]++;
                k++;
            }
        }
        int l = 0;
        int r = 0;
        int n = nums.length;
        int cnt = 0;
        int ans = 0;
        while(r < n){
            if(hash[nums[r]] > 0) cnt++;
            hash[nums[r]]--;
            while(cnt == k){
                ans += n - r;
                hash[nums[l]]++;
                if(hash[nums[l]] > 0) cnt--;
                l++;
            }
            r++;
        }
        return ans;
    }
}