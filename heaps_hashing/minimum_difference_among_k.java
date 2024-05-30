class Solution
{
    long minDiff(long a[] ,int N,int K)
    {
        Arrays.sort(a);
        long ans = Integer.MAX_VALUE;
        int l = 0;
        int r = K-1;
        while(r < N){
            ans = Math.min(ans, Math.abs(a[l] - a[r]));
            l++;
            r++;
        }
        return ans;
    }
}
