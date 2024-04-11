//brute force
class Solution {
public:
    bool isAnagram(string s1 ,string s2){
        unordered_map<char, int> freq;
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            freq[ch] = 0;
        }
        for(auto x : s1){
            freq[x]++;
        }
        for(auto x : s2){
            freq[x]--;
        }
        for(char ch = 'a' ; ch <= 'z' ; ch++){
            if(freq[ch] != 0) return false;
        }
        return true;
    }
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        int n = strs.size();
        vector<int> marked(n, 0);
        for(int i = 0 ; i < n ; i++){
            vector<string> temp;
            if(marked[i] == 0){
                temp.push_back(strs[i]);
                marked[i] = 1;
            }
            for(int j = 0 ; j < n ; j++){
                if(i != j && isAnagram(strs[i], strs[j])){
                    if(marked[j] == 0){
                        temp.push_back(strs[j]);
                        marked[j] = 1;
                    }
                }
            }
            if(temp.size() != 0){
                ans.push_back(temp);
            }
            temp.clear();
        }
        return ans;
    }
};

//more efficient approach
class Solution {
public:

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        unordered_map<string, vector<string>> ana;
        for(auto it : strs){
            string s = it;
            sort(s.begin(), s.end());
            ana[s].push_back(it);
        }
        for(auto x : ana){
            ans.push_back(x.second);
        }
        return ans;
    }
};


//the following approach is using the hash map of string and vector of strng
