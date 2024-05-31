class Solution {
    public static class Pair{
        String s;
        int x;
        public Pair(String s, int x){
            this.s = s;
            this.x = x;
        }
    }
    public int helper(String s){
        int num = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0;
        int digit = 1;
        while(i < s.length()){
            mp.putIfAbsent(s.charAt(i), digit++);
            num = num*10 + mp.get(s.charAt(i));
            i++;
        }
        return num;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        List<Pair> mp = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++){
            mp.add(new Pair(words[i], helper(words[i])));
        }
        int X = helper(pattern);
        for(int i = 0 ; i < mp.size() ; i++){
            Pair p = mp.get(i);
            if(p.x == X) ans.add(p.s);
        }
        return ans;
    }
}