class Solution {
    public void helper(List<String> ans, String str, int left, int right, int n){
        if(str.length() == 2*n){
            ans.add(str);
            return;
        }
        if(left < n){
            helper(ans, str + "(", left+1, right, n);
        }
        if(right < left){
            helper(ans, str + ")", left, right + 1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        helper(ans, "", 0, 0, n);
        return ans;
    }
}