class Solution {
    public void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if(r < n && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }
    public void buildHeap(int[] arr, int n){
        for(int i = n/2 - 1 ; i >= 0 ; i--){
            heapify(arr, n, i);
        }
    }
    public void heapSort(int[] arr, int n){
        buildHeap(arr, n);
        for(int i = n - 1 ; i > 0 ; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        heapSort(nums, n);
        return nums;
    }
}