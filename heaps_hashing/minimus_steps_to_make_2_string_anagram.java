class Solution {
    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int minSteps(String s, String t) {
        Map<Character, Pair> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mp.putIfAbsent(ch, new Pair(0, 0));
            Pair p = mp.get(ch);
            p.x += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mp.putIfAbsent(ch, new Pair(0, 0));
            Pair p = mp.get(ch);
            p.y += 1;
        }
        int ans = 0;
        for(Map.Entry<Character, Pair> e : mp.entrySet()){
            Pair p = e.getValue();
            ans += Math.abs(p.x - p.y);
        }
        return ans/2;
    }
}