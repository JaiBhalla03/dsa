class Solution {
public:
    bool isPalin(string word){
        int r = word.size()-1;
        int l = 0;
        while(l<=r){
            if(word.at(l) != word.at(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    string firstPalindrome(vector<string>& words) {
        for(int i = 0 ; i<words.size() ; i++){
            if(isPalin(words[i])){
                return words[i];
            }
        }
        return "";
    }
};
