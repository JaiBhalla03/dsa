class Solution{
public:
    vector<int> findTwoElement(vector<int> arr, int n) {
        //using the mathmatical method 
        long sum = (n*(n+1))/2;
        long sumSq =(n*(n+1)*(2*n+1))/6;
        long sumR = 0;
        long sumRSq = 0;
        for(int i = 0 ; i < n ; i ++){
            sumR += (long long)arr[i];
            sumRSq += (long long)arr[i]*(long long)arr[i];
        }
        long long xmy = sumR - sum;
        long long xmsqy = sumRSq - sumSq;
        long long xpy = xmsqy/xmy;
        int x = (xmy + xpy)/2;
        int y = x - xmy;
        return {x,y};
    }
};