class Solution {
public:
    int compress(vector<char>& chars) {
        vector<int> temp;
        chars.push_back('-1000');
        int count = 1;
        int n = chars.size();
        for(int i = 0; i<n-1; i++){
            if(chars[i] == chars[i+1]){
                count++;
            }
            else{
                if(count > 1){
                    temp.push_back(chars[i]);
                    string s = to_string(count);
                    for(auto x : s){
                        temp.push_back(x);
                    }
                    count = 1;
                }
                else{
                    temp.push_back(chars[i]);
                }
            }
        }
        while(!chars.empty()){
            chars.pop_back();
        }
        for(auto x : temp){
            chars.push_back(x);
        }
        return chars.size();
    }
};