class Solution {
public:
    string truncateSentence(string s, int k) {
        s+=" ";
        string n = "";
        string w = "";
        for(int i = 0 ; i < s.size() ; i++){
            char c = s[i];
            if(c != ' '){
                w+=c;
            }
            else{
                n+=w + " ";
                w = "";
                k--;
                if(k == 0) break;
            }
        }
        return n.substr(0, n.size()-1);
    }
};