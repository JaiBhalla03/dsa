class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        while(j < n){
            int fruit = fruits[j];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            while(map.keySet().size() > 2){
                int startFruit = fruits[i];
                if(map.get(startFruit) == 1) map.remove(startFruit);
                else map.put(startFruit, map.get(startFruit) - 1);
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}