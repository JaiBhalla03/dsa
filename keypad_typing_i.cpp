void helper(char left, char right, int num , unordered_map<char, int> &freq){
    for(char ch = left ; ch <= right ; ch++){
        freq[ch] = num;
    }
}
string printNumber(string s, int n)
{
    unordered_map<char, int> freq;
    helper('a', 'c', 2, freq);
    helper('d', 'f', 3, freq);
    helper('g', 'i', 4, freq);
    helper('j', 'l', 5, freq);
    helper('m', 'o', 6, freq);
    helper('p', 's', 7, freq);
    helper('t', 'v', 8, freq);
    helper('w', 'z', 9, freq);
    string ans = "";
    for(int i = 0 ; i < s.size() ; i ++){
        ans += to_string(freq[s[i]]);
    }
    return ans;
}