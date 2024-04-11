class Solution {
public:
    int minOperations(int n) {
        vector<int> arr;
        for(int i = 0 ; i < n ; i++){
            arr.push_back(2*i + 1);
        }
        int l = arr.size();
        //some base cases 
        if(l == 0 || l == 1){
            return 0;
        }
        if(l == 2){
            return 1;
        }
        int operation = 0;
        //if odd
        if(l % 2 != 0){
            int mid = l/2;
            int common = arr[mid];
            for(int i = 0 ; i < mid ; i++){
                operation += common - arr[i];
            }
        }
            //if even
        else{
            int mid = l/2;
            int common =  arr[mid] - 1;
            for(int i = 0 ; i<mid ; i++){
                operation += common - arr[i];
            }
        }
        return operation;
    }
};

//efficient approach
class Solution {
public:
    int minOperations(int n) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;
        int adder = (n%2 == 1) ? 0 : 1;
        int l = n/2;
        int ans = 0;
        while(l !=0 ){
            ans += l*2;
            ans -= adder;
            l--;
        }
        return ans;
    }
};