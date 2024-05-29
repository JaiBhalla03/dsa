class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int l = 0;
        int r = k;
        int sum = 0;
        int count = 0;
        for(int i = 0 ; i < r; i++) sum += arr[i];
        while(r <= n){
            if(sum / k >= threshold){
                count++;
            }
            sum -= arr[l];
            if(r < n) sum += arr[r];
            l++; r++;
        }
        return count;
    }
}