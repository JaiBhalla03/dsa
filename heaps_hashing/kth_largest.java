class Solution {
    void heapify(int[] arr, int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l < n && arr[l] > arr[largest]) largest = l;
        if(r < n && arr[r] > arr[largest]) largest = r;
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }
    void buildHeap(int[] arr, int n){
        for(int i = n/2 - 1 ; i >= 0 ; i--){
            heapify(arr, n, i);
        }
    }
    int[] kLargest(int[] arr, int n, int k) {
        int[] ans = new int[k];
        int j = 0;
        buildHeap(arr, n);
        for(int i = n - 1 ; i > 0 ; i--){
            if(j < k) ans[j++] = arr[0];
            else break;
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
        if(k == n){
            ans[k-1] = arr[0];
        }
        return ans;
    }
}