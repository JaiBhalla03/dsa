class Solution {
    public String shortestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.startsWith(t.substring(i))){
                return t.substring(0, i) + s;
            }
        }
        return t + s;
    }
}