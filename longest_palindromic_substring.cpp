//brute force approach
class Solution {
public:
    bool isPalindrome(string s){
        int right = s.size()-1;
        for(int left = 0 ; left < s.size() ; left++){
            if(s[left] != s[right]) return false;
            right--;
        }
        return true;
    }
    string longestPalindrome(string s) {
        string str = "";
        int maxLen = 0;
        for(int i = 0  ;i <s.size() ; i++){
            string temp = "";
            for(int j = i  ; j < s.size() ; j++){
                temp += s[j];
                if(isPalindrome(temp)){
                    if(maxLen < temp.size()){
                        maxLen = temp.size();
                        str = temp;
                    }
                }
            }
        }
        return str;
    }
};

//efficient approach
class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        if(n == 0) return "";
        int start = 0;
        int maxLen = 1;
        for(int i = 0 ; i < n ; i++){
            //palindrome for strings that are of odd length
            int left = i, right = i;
            while(left >= 0 && right < n && s[left] == s[right]){
                if(right - left + 1  > maxLen){
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right ++;
            }

            //palindrome for strings that are of even length
            left = i, right = i + 1;
            while(left >= 0 && right < n && s[left] == s[right]){
                if(right - left + 1 > maxLen){
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return s.substr(start, maxLen);
    }
};

