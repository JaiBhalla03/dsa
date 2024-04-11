class Solution{
public:
    long long int minSum(int arr[], int n)
    {
        vector<int> ar;
        for(int i = 0 ; i < n ; i++){
            ar.push_back(arr[i]);
        }
        long long int num1 = 0; long long int num2 = 0;
        std::sort(ar.begin(), ar.end());
        bool flag = true;
        for(int i = 0 ; i < ar.size() ; i++){
            if(flag){
                num1 = num1*10 + ar[i];
            }
            else{
                num2 = num2*10 + ar[i];
            }
            flag = !flag;
        }
        return num1 + num2;
    }
};