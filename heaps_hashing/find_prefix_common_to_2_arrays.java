class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        if(n == 1) return new int[]{1};
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            int x = A[i];
            int y = B[i];
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            mp.put(y, mp.getOrDefault(y, 0) + 1);
            if(x == y){
                if(mp.get(x) > 1) count++;
            }
            else{
                if(mp.get(x) > 1) count++;
                if(mp.get(y) > 1) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}