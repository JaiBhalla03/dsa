class Solution {
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {
        int l = 0;
        int r = k;
        int n = s.length();
        int count = 0;
        int ans = 0;
        for(int i = l ; i < r ; i++){
            char ch = s.charAt(i);
            if(isVowel(ch)) count++;
        }
        while(r < n){
            ans = Math.max(ans, count);
            char ch1 = s.charAt(r);
            char ch2 = s.charAt(l);
            if(isVowel(ch1)) count++;
            if(isVowel(ch2)) count--;
            l++; r++;
        }
        ans = Math.max(ans, count);

        return ans;
    }
}