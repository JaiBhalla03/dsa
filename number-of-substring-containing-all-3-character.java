class Solution {
    public int numberOfSubstrings(String s) {
        int[] track = new int[3];
        int n = s.length();
        int res = 0;
        int left = 0;
        for(int i = 0 ; i < n ; i++){
            track[s.charAt(i) - 'a']++;
            while(track[0] > 0 && track[1] > 0 && track[2] > 0){
                res += s.length() - i;
                track[s.charAt(left++) - 'a']--;
            }
        }
        return res;
    }
}