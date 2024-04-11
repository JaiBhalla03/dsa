//brute force approach

class Solution {
public:
    int findLucky(vector<int>& arr) {
        int lucky = 0;
        int flag = 0;
        int count = 0;
        for(int i = 0 ; i < arr.size() ; i++){
            for(int j = 0 ; j < arr.size() ; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count == arr[i]){
                flag = 1;
                lucky = max(lucky, arr[i]);
            }
            count = 0;
        }
        if(flag == 0){
            return -1;
        }
        else{
            return lucky;
        }
    }
};

//efficient approach

class Solution {
public:
    int findLucky(vector<int>& arr) {
        std::sort(arr.begin() , arr.end());
        int i = 0, j = 0;
        int n = arr.size() - 1;
        int count = 0;
        bool flag = false;
        int lucky = 0;
        while(j != n){
            while(arr[i] == arr[j] && j != n){
                j++;
                count++;
            }
            if(j == n && arr[j] == arr[i]){
                count++;
            }
            if(count == arr[i]){
                cout << count;
                flag = true;
                lucky = max(lucky, arr[i]);
            }
            count = 0;
            i = j;
        }
        return flag ? lucky : -1;
    }
};