class Solution {
public:
    int binarysearch(int arr[], int n, int k) {
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if(arr[mid] == k) return mid;
            else if(arr[mid] > k){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
};