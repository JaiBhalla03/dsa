class Solution {
public:
    bool isPalindrome(string s) {
        if(s==""){
            return true;
        }
        int left = 0;
        int right = s.size() - 1;
        while(left < right){
            s[left] = tolower(s[left]);
            s[right] = tolower(s[right]);
            if(!isalnum(s[left])){
                left ++;
            }
            else if(!isalnum(s[right])){
                right--;
            }
            else if(s[left] != s[right]){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
};