class Solution{
public:
    int missingNumber(vector<int>& array, int n) {

        int total = ((n)*(n + 1))/2;
        for(int i = 0 ; i < n-1 ; i++){
            total -= array[i];
        }

        return total;
    }
};
