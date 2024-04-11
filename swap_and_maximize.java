class GFG
{
    long maxSum(long arr[] ,int n)
    {
        Arrays.sort(arr);
        long ans = 0;
        for(int i =  0 ; i < n/2 ; i++){
            ans -= (2*arr[i]);
            ans += (2*arr[n-i - 1]);
        }
        return ans;
    }
}