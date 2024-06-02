class Solution {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((b, a) -> (a.getValue() - b.getValue()));

        for(Map.Entry<Character, Integer> e : mp.entrySet()){
            pq.add(e);
        }

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return result.toString();
    }
}