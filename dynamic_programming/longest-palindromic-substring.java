class Solution {
    public String longestPalindrome(String s) {
        if(s == "") return "";
        int maxLen = 1;
        int start = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            //if the palidromic substring in odd
            int left = i; int right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if(maxLen < right - left + 1){
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }

            //if the palindromic substring is even
            left = i; right = i+1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if(maxLen < right - left + 1){
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, start + maxLen);
    }
}