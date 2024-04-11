class Solution {
public:
    bool contains(char c, string s){
        for(int i = 0 ; i<s.size() ; i++){
            if(c == s[i]) return true;
        }
        return false;
    }
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        vector<char> a = {'M', 'P', 'G'};
        int result = 0;
        int sum;
        for(char c : a){
            sum = 0;
            for(int i = 0 ; i<travel.size() ; i++){
                sum += travel[i];
            }
            for(int i = travel.size()-1 ; i >= 0; i--){
                if(!contains(c, garbage[i+1])){
                    sum-=travel[i];
                }
                else{
                    break;
                }
            }

            for(string s : garbage){
                for(int i = 0  ;i<s.size() ; i++){
                    if(c==s[i]) sum++;
                }
            }
            result+=sum;
        }
        return result;
    }
};