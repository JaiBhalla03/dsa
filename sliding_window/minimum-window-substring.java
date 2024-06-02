class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] hash = new int[256];
        for(int i = 0 ; i < m ; i++){
            int index = t.charAt(i);
            hash[index] ++;
        }
        int l = 0;
        int r = 0;
        int minLen = (int)(1e9);
        int startIndex = -1;
        int count = 0;
        while(r < n){
            int index = s.charAt(r);
            if(hash[index] > 0) count++;
            hash[index]--;
            while(count == m){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    startIndex = l;
                }
                int i = s.charAt(l);
                hash[i]++;
                if(hash[i] > 0) count = count - 1;
                l++;
            }
            r++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}