class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //the following question can also be done using the binary search
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if(mid == 0 || mid == arr.length - 1) return mid;
            if(arr[mid] < arr[mid - 1]){
                right = mid;
            }
            else if(arr[mid] < arr[mid + 1]){
                left = mid;
            }
            else return mid;
        }
        return left;
    }
}