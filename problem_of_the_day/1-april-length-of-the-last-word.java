class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        s = s + " ";
        int n = s.length();
        String w = "";
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                w = w + " ";
            }
            else{
                ans = w.length();
                w = "";
            }
        }
        return ans;
    }
}


//better approach
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        if(n == 0) return 0;
        int i = n-1;
        int ans = 0;
        while(i >= 0 && s.charAt(i) != ' '){
            ans++;
            i--;
        }
        return ans;
    }
}

//this one beats 100% of the solution