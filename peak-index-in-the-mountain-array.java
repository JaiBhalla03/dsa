class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        while(first <= last){
            int mid = first + (last - first)/2;
            if(mid > 0 && mid < arr.length - 1 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if(mid-1 >= 0 && arr[mid] < arr[mid-1]){
                last = mid-1;
            }
            else{
                first = mid+1;
            }
        }
        return -1;
    }
}