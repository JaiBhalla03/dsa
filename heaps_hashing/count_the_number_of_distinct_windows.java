class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0 ; i < k ; i++){
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);
        }
        int l = 0;
        int r = k;
        while(r < n){
            ans.add(mp.size());
            mp.put(A[r], mp.getOrDefault(A[r], 0) + 1);
            if(mp.get(A[l]) == 1){
                mp.remove(A[l]);
            }
            else{
                mp.put(A[l], mp.get(A[l]) - 1);
            }
            l++;
            r++;
        }
        ans.add(mp.size());
        return ans;
    }
}

