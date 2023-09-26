class Solution {
public:
    string rev(string s){
        string n = "";
        for(int i = s.size()-1 ; i>=0 ; i--){
            n += s[i];
        }
        return n;
    }
    string finalString(string s) {
        string n = "";
        for(int i = 0 ; i< s.size() ; i++){
            if(s[i] == 'i'){
                n = rev(n);
            }
            else{
                n+=s[i];
            }
        }
        return n;
    }
};