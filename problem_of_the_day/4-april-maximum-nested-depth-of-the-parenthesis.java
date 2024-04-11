class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int result = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(') ans++;
            else if(s.charAt(i) == ')') ans--;
            result = Math.max(result, ans);
        }
        return result;
    }
}