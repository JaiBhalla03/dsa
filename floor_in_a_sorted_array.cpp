class Solution{
public:
    // Function to find floor of x
    // n: size of vector
    // x: element whose floor is to find
    int findFloor(vector<long long> v, long long n, long long x){
        if(v[n-1] <= x) return n-1;
        if(v[0] > x) return -1;
        for(long long i = 1 ; i < n ; i++){
            if(v[i] > x){
                return i-1;
            }
        }
        return -1;
    }
};