class Solution {
    public int minimumLength(String s) {
        int l = 0;
        int r = s.length() - 1;
        int[] marked = new int[s.length()];
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                break;
            }
            else{
                char ch = s.charAt(l);
                while(l <= r && s.charAt(l) == ch){
                    marked[l] = 1;
                    l++;
                }
                while(r >= 0 && s.charAt(r) == ch){
                    marked[r] = 1;
                    r--;
                }
            }
        }
        int ans = 0;
        for(int x : marked){
            if(x == 0) ans++;
        }
        return ans;
    }
}