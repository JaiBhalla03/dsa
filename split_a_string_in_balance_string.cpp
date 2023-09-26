class Solution {
public:
    int balancedStringSplit(string s) {
        int count =  0;
        int countRL = 0;
        for(int i = 0 ; i < s.size() ; i++){
            if(s[i] == 'R') countRL++;
            if(s[i] == 'L') countRL--;
            if(countRL == 0){
                count++;
                countRL = 0;
            }
        }
        return count;
    }
};