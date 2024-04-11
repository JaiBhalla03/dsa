//brute force

class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        int freq1 = 0;
        int freq2 = 0;
        int count = 0;
        for(int i = 0  ; i < words1.size() ; i++){
            string s = words1[i];
            for(int j =  0 ; j < words1.size() ; j ++){
                if(words1[j] == s){
                    freq1++;
                }
            }
            for(int j =  0 ; j < words2.size() ; j ++){
                if(words2[j] == s){
                    freq2++;
                }
            }
            if(freq1 == 1 && freq2 == 1){
                count++;
            }
            freq1 = 0;
            freq2 = 0;
        }
        return count;
    }
};

//efficient approach
class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        unordered_map<string, pair<int, int>> freq;
        int count  =0;
        for(string word : words1){
            freq[word].first ++;
        }
        for(string word : words2){
            freq[word].second++;
        }
        for(auto i : freq){
            if(i.second.first == 1 && i.second.second == 1){
                count++;
            }
        }
        return count;
    }
};