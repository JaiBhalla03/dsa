class Solution {
public:
    void helper(vector<int>& arr, int n , int index, int k){
        if(n == 1){
            return;
        }
        index = (index + k - 1)%n;
        arr.erase(arr.begin() + index);
        n--;
        helper(arr, n, index, k);
    }
    int findTheWinner(int n, int k) {
        vector<int> arr(n, 0);
        for(int i  = 0 ; i< n ;i++){
            arr[i] = i+1;
        }
        helper(arr, n , 0, k);
        return arr[0];
    }
};