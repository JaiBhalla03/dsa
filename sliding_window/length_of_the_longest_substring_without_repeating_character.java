class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int i = 0, j = 0;
        int n = s.length();
        int len = 0;
        int maxLen = len;
        while(j < n){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                len = j - i + 1;
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}