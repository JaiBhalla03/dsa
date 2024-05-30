class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a-b));

        for(int i =0 ; i < n ; i++){
            if(pq.size() < k) pq.add(arr[i]);
            else{
                if(arr[i] > pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
            if(pq.size() < k){
                res[i] = -1;
            }
            else res[i] = pq.peek();
        }
        return res;
    }
};