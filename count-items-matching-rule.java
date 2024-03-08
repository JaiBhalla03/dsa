class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        if(ruleKey.equals("type")) index = 0;
        else if(ruleKey.equals("color")) index = 1;
        else index = 2;
        int count = 0;
        for(int i = 0 ; i < items.size() ; i++){
            if(ruleValue.equals(items.get(i).get(index))) count++;
        }
        return count;
    }
}