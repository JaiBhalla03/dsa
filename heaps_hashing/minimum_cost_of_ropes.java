class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n)
    {
        long ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long x : arr){
            pq.add(x);
        }

        while(pq.size() != 1){
            long a = pq.poll();
            long b = pq.poll();
            ans += a + b;
            pq.add(a + b);
        }
        return ans;
    }
}