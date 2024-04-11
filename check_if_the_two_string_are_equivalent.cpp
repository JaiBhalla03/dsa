class Solution {
public:
    string convertToWord(vector<string> &word){
        string w = "";
        for(int i = 0 ; i<word.size() ; i++){
            w+=word[i];
        }
        return w;
    }
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string w1 = convertToWord(word1);
        string w2 = convertToWord(word2);
        int n1 = w1.size();
        int n2 = w2.size();
        if(n1 == n2){
            for(int i = 0  ;i<n1;i++){
                if(w1[i] != w2[i]){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
};