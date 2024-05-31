class GfG
{
    int maxLen(int arr[], int n)
    {
        int ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            if(sum == 0){
                ans = i + 1;
            }
            Integer prev = mp.get(sum);
            if(prev != null){
                ans = Math.max(ans, i - prev);
            }
            else{
                mp.put(sum, i);
            }
        }
        return ans;
    }
}