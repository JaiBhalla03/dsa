class Solution {
    public int minimumCardPickup(int[] arr) {
        int n = arr.length;
        if(n == 1) return -1;
        int l = 0;
        int r = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = (int)(1e9);
        while(r < n){
            mp.put(arr[r], mp.getOrDefault(arr[r], 0) + 1);
            while(mp.get(arr[r]) == 2) {
                ans = Math.min(ans, r - l + 1);
                if(mp.get(arr[l]) == 1) mp.remove(arr[l]);
                else mp.put(arr[l], mp.get(arr[l]) - 1);
                l++;
            }
            r++;
        }
        return ans == (int)(1e9) ? -1 : ans;
    }
}