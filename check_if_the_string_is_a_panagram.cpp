class Solution {
public:
    bool checkIfPangram(string sentence) {
        unordered_map<char, int> freq;
        for(int i = 0 ; i < sentence.size() ; i++){
            freq[sentence[i]]++;
        }
        return freq.size() == 26;
    }
};