class Solution {
    public boolean isAnagram(String str1, String str2){
        int[] count = new int[26];
        for(int i = 0 ; i < str1.length() ; i++){
            count[str1.charAt(i) - 97]++;
        }
        for(int i = 0 ; i < str2.length() ; i++){
            count[str2.charAt(i) - 97]--;
        }
        for(int x : count){
            if(x > 0) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = p.length();
        int n = s.length();
        while(r <= n){
            if(isAnagram(p, s.substring(l, r))){
                ans.add(l);
            }
            l++;
            r++;
        }

        return ans;
    }
}