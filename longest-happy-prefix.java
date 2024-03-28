class Solution {
    public String longestPrefix(String s) {
        List<String> prefixes = new ArrayList<>();

        String temp = "";
        for(int i = 0 ; i < s.length()-1; i++){
            temp = temp + s.charAt(i);
            prefixes.add(temp);
        }
        String ans = "";
        for(int i = 0 ; i < prefixes.size() ; i++){
            if(s.endsWith(prefixes.get(i))){
                if(ans.length() < prefixes.get(i).length()){
                    ans = prefixes.get(i);
                }
            }
        }
        return ans;
    }
}