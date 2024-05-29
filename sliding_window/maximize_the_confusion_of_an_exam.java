class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = answerKey.charAt(i) == 'T' ? 1 : 0;
        }
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int count = 0;
        //try to find the max number of consecutive 1's
        while(r < n){
            if(arr[r] == 0){
                count++;
            }
            if(count > k){
                if(arr[l] == 0) count--;
                l++;
            }
            if(count <= k){
                maxLen = Math.max(maxLen, r-l + 1);
            }
            r++;
        }
        //try to find the max number of consecutive 0's
        r = 0; l = 0; count = 0;
        while(r < n){
            if(arr[r] == 1){
                count++;
            }
            if(count > k){
                if(arr[l] == 1) count--;
                l++;
            }
            if(count <= k){
                maxLen = Math.max(maxLen, r-l + 1);
            }
            r++;
        }
        return maxLen;
    }
}