class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int g = x - arr[i];
            Integer flag = mp.get(g);
            if(flag != null){
                return true;
            }
            else{
                mp.put(arr[i], g);
            }
        }
        return false;
    }
}