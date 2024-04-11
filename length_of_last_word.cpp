class Solution {
public:
    string trim(string s){
        string copy = "";
        int n = s.size();
        int flag = 0;
        for(int i = n-1;i>=0;i--){
            if(s.at(i) == ' ' && flag == 0){
                continue;
            }
            else{
                flag = 1;
                copy = s.at(i) + copy;
            }
        }
        return copy;
    }
    int lengthOfLastWord(string s) {
        s = trim(s);
        s = s + " ";
        int n = s.size();
        int current_length;
        string w = "";
        int i;
        for(i = 0;i<n;i++){
            char letter = s.at(i);
            if(letter != ' '){
                w = w+letter;
            }
            else{
                current_length = w.size();
                w = "";
            }
        }
        return current_length;
    }
};