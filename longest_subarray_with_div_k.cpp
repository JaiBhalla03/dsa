class Solution{
public:
    int longSubarrWthSumDivByK(int arr[], int n, int k)
    {
        int sum = 0;
        int rem;
        int mx = 0;
        unordered_map<int, int> mp;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            rem = sum%k;
            if(rem == 0){
                mx = max(mx, i+1);
            }
            if(rem < 0){
                rem += k;
            }
            if(mp.find(rem) != mp.end()){
                mx = max(mx, i - mp[rem]);
            }
            else{
                mp[rem] = i;
            }
        }
        return mx;
    }
};