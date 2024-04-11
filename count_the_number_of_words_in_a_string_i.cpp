int countWords(string s)
{
    if(s == "") return 0;
    int count = 0;
    string temp = "";
    vector<string> words;
    s = s + ' ';
    for(int i = 0 ; i < s.size() ; i++){
        if(s[i] == ' '){
            words.push_back(temp);
            temp = "";
        }
        temp += s[i];
    }
    for(int i = 0 ; i < words.size() ; i ++){
        if(words[i].size() != 0) count++;
    }
    return count;
}