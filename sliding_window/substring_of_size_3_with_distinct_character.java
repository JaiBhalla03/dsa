class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0; int r = 2;
        for(int i = 0 ; i <= r ; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int ans = 0;
        int n = s.length();
        while(r < n){
            System.out.println(map.keySet().size());
            if(map.keySet().size() == 3) ans ++;
            r++;
            if(map.get(s.charAt(l)) == 1) map.remove(s.charAt(l));
            else map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
            if(r < n) map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            l++;
        }
        return ans;
    }
}