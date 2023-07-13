class Solution {
public:
    string trim(string s){
        string trimmed_string = "";

        s = s+"  ";
        int i;
        vector<string> word_array;
        string w = "";
        for(int i = 0;i<s.size();i++){
            char ch = s.at(i);
            if(ch != ' '){
                w = w+ch;
            }
            else{
                word_array.push_back(w);
                w = "";
            }
        }
        //remove the white spaces from the word array
        //vector<int>::iterator new_end;
        word_array.erase(std::remove(word_array.begin(), word_array.end(), ""));
        for(int j = 0;j<word_array.size(); j++){
            trimmed_string = trimmed_string + word_array[j] + " ";
        }
        string copy_trimmed_string;
        for(int k = 0;k<trimmed_string.size() -1;k++){
            copy_trimmed_string = copy_trimmed_string + trimmed_string.at(k);
        }
        return copy_trimmed_string;
    }
    string trim_end(string s){
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
    string reverseWords(string s) {
        s = trim(s);
        s = trim_end(s);
        // return s;
        s = s  + " ";
        int n = s.size();
        string new_string = "";
        string w = "";
        int i;
        for(i = 0;i<n;i++){
            char c = s.at(i);
            if(c != ' '){
                w = w+c;
            }
            else{
                new_string = w + " " + new_string;
                w  = "";
            }
        }
        string final_string = "";
        for(int j = 0;j<n-1;j++){
            final_string = final_string + new_string.at(j);
        }
        return final_string;
    }
};