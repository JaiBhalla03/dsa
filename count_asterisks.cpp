class Solution {
public:
    int countAsterisks(string s) {
        int countBar = 0;
        int countAsterisks = 0;
        int len = s.size();
        int i;
        for(i = 0 ; i < len ; i++){
            if(s[i] == '*' && countBar%2 == 0){
                countAsterisks++;
            }
            else if(s[i] == '|'){
                countBar++;
            }
        }
        return countAsterisks;
    }
};