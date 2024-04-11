class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false;
        unordered_map<char, int> freq;
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            freq[ch] = 0;
        }
        for(int i = 0 ; i < s.size() ; i++){
            freq[s[i]]++;
        }
        for(int i = 0 ; i < t.size() ; i++){
            freq[t[i]]--;
        }
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            if(freq[ch] != 0) return false;
        }
        return true;
    }
};