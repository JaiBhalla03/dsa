class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //using the min heap
        priority_queue<int, vector<int>, greater<int>> pq;
        for(auto x : nums){
            pq.push(x);
            if(pq.size() > k){
                pq.pop();
            }
        }
        return pq.top();
    }
};