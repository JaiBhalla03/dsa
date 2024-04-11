class Solution {
public:
    string sortSentence(string s) {
        vector<pair<string, int>> str;
        s = s + " ";
        string w = "";
        string nw = "";
        for(int i = 0  ; i < s.size() ; i++){
            char ch = s[i];
            if(ch != ' '){
                w = w + ch;
            }
            else{
                for(int j = 0 ; j < w.size()-1 ; j++){
                    nw = nw + w[j];
                }
                pair<string, int> p = make_pair(nw, (int)w[w.size()-1] - 48);
                str.push_back(p);
                nw = "";
                w = "";
            }
        }
        for(int i = 0 ; i < str.size() ; i ++){
            int smallest = i;
            for(int j = i+1 ; j < str.size(); j++){
                if(str[j].second < str[smallest].second){
                    smallest = j;
                }
            }
            string temp = str[smallest].first;
            str[smallest].first = str[i].first;
            str[i].first = temp;
            int t = str[smallest].second;
            str[smallest].second = str[i].second;
            str[i].second = t;
        }
        string ans = "";
        for(int i = 0 ; i<str.size() ; i++){
            if(i != str.size()-1){
                ans += str[i].first + " ";
            }
            else{
                ans += str[i].first;
            }
        }
        return ans;
    }
};