//brute force
class Solution {
public:
    void helper(vector<string> &subsequences, string str, int index, string temp){
        if(index == str.size()){
            subsequences.push_back(temp);
            return;
        }
        temp = temp + str[index];
        helper(subsequences, str, index + 1, temp);
        temp = temp.substr(0 ,temp.size()-1);
        helper(subsequences, str, index + 1, temp);
    }
    bool isSubsequence(string s, string t) {
        vector<string> subsequences;
        int index = 0;
        helper(subsequences, t, index, "");
        for(auto x : subsequences){
            if(x == s){
                return true;
            }
        }
        return false;
    }
};

//here we will find all the subsquences of the string to check if true but the memory limit will exceed therefore use two pointer approach

// efficient approach
class Solution {
public:
    bool isSubsequence(string s, string t) {
        int i = 0, k = 0;
        for(int i=0 ; i < t.size() ; i++){
            if(t[i] == s[k]){
                k++;
            }
        }
        return k == s.size();
    }
};