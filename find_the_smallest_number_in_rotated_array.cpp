class Solution{
public:
    int findMin(int arr[], int n){

        for(int i = 1 ; i < n ; i++){
            if(arr[i-1] > arr[i]){
                return arr[i];
            }
        }
        return arr[0];
    }
};