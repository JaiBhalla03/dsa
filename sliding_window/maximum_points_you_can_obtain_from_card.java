class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        for(int i = 0 ; i < k ; i++){
            lsum += cardPoints[i];
        }
        int sum = lsum + rsum;
        int maxSum = sum;
        int l = k-1;
        int r = cardPoints.length - 1;
        int limit = r - k;
        while(r > limit){
            lsum -= cardPoints[l];
            l--;
            rsum += cardPoints[r];
            r--;
            sum = lsum + rsum;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}