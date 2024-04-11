class Solution {
public:
    string toGoatLatin(string s) {
        s = s + " ";
        string w = "";
        string copyw = "";
        string n = "";
        string wa = "";
        int count = 0;
        for(int i = 0 ; i < s.size() ; i ++){
            if(s[i] != ' '){
                w = w + s[i];
            }
            else{
                if(w[0] != 'a' && w[0] != 'e' && w[0] != 'i' && w[0] != 'o' && w[0] != 'u' && w[0] != 'A' && w[0] != 'E' && w[0] != 'I' && w[0] != 'O' && w[0] != 'U'){
                    //word starts with consonent
                    for(int j = 1 ; j < w.size() ; j++){
                        copyw+=w[j];
                    }
                    copyw+=w[0];
                    w = copyw;
                    copyw="";
                }
                w = w + "ma";
                count++;
                for(int k = 0 ; k<count ; k++){
                    wa+="a";
                }
                w = w + wa;
                n = n + w + " ";
                wa = "";
                w = "";
            }
        }
        string final = "";
        for(int i = 0 ; i < n.size()-1 ; i++){
            final += n[i];
        }
        return final;
    }
};