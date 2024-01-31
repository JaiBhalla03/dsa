ass Solution{
        public:
        long long countTriplets(long long arr[], int n, long long sum)
        {
            // 1.) sort the array
            sort(arr, arr + n);
            int ans = 0;
            int i, j, k;
            for(i = 0 ; i < n-2 ; i++){
                j = i + 1;
                k = n - 1;
                while(j < k){
                    if(arr[i] + arr[j] + arr[k] >= sum){
                        k--;
                    }
                    else{
                        ans += k-j;
                        j++;
                    }
                }
            }
            return ans;
        }
};