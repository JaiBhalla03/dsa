//brute force
class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int[] count = {0, 0};
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i ; j < nums.length ; j++){
                count[nums[j]]++;
                if(count[0] == count[1]) maxLen = Math.max(maxLen, j-i + 1);
            }
            count[0] = 0;
            count[1] = 0;
        }
        return maxLen;
    }
}

//optimised approach
class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            sum += (nums[i] == 0) ? -1 : 1;
            if(sum == 0){
                ans = i+1;
            }
            else if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return ans;
    }
}