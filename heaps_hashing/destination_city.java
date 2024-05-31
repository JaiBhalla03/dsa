class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> mp = new HashMap<>();
        for(int i = 0 ; i < paths.size() ; i++){
            String s1 = paths.get(i).get(0);
            String s2 = paths.get(i).get(1);
            mp.put(s1, "$" + mp.getOrDefault(s1, ""));
            mp.put(s2, mp.getOrDefault(s2, "") + "#");
        }
        for(Map.Entry<String, String> e : mp.entrySet()){
            if(e.getValue().startsWith("#")) return e.getKey();
        }
        return "";
    }
}