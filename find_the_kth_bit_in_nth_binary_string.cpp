class Solution {
public:
    string reverse(string s){
        int n = s.size();
        int k = n-1;
        for(int i = 0 ; i<n/2 ; i++){
            char temp = s[i];
            s[i] = s[k];
            s[k] = temp;
            k--;
        }
        return s;
    }
    string invert(string s){
        for(int i = 0 ; i < s.size() ;i++){
            s[i] = (s[i] == '0') ? '1' : '0';
        }
        return s;
    }
    string helper(int n){
        if(n == 1) return "0";
        n--;
        return helper(n) + "1" + reverse(invert(helper(n)));
    }
    char findKthBit(int n, int k) {
        string s = helper(n);

        cout<<s;
        return s[k-1];
    }
};