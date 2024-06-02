class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        Map<String, Integer> mp = new HashMap<>();
        for(String str : words){
            PriorityQueue<Character> pq = new PriorityQueue<>();
            for(int i = 0 ; i < str.length() ; i++){
                pq.add(str.charAt(i));
            }
            String newStr = "";
            while(!pq.isEmpty()){
                newStr = newStr + pq.poll();
            }
            mp.put(newStr, mp.getOrDefault(newStr, 0) + 1);
        }
        int ans = 0;
        for(int x : mp.values()){
            if(x == 2) ans++;
        }
        return ans;
    }
}