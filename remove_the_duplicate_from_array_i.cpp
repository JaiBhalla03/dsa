class Solution{
public:
    int remove_duplicate(int a[],int n){
        int index = 1;
        if(n == 1 || n == 0) return n;
        for(int i = 1 ; i < n ; i++){
            if(a[i-1] != a[i]){
                a[index++] = a[i];
            }
        }
        return index;
    }
};