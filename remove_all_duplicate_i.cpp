public:
string removeDuplicates(string str) {
    string s = "";
    unordered_map<char, int> freq;
    for(char ch = 'a' ; ch <= 'z' ; ch++){
        freq[ch] = 0;
    }
    for(int i = 0 ; i < str.size() ; i++){
        if(freq[str[i]] == 0){
            s += str[i];
        }
        freq[str[i]]++;
    }
    return s;
}
};