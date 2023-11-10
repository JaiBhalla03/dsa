class Solution
{
public:
    //Function is to check whether two strings are anagram of each other or not.
    bool isAnagram(string a, string b){
        unordered_map<char, int> freq;
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            freq[ch] = 0;
        }
        for(auto x : a){
            freq[x]++;
        }
        for(auto x : b){
            freq[x]--;
        }
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            if(freq[ch] != 0) return false;
        }
        return true;
    }

};
