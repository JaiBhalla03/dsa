class Solution {
    public List<String> cellsInRange(String s) {
        char minLetter = 'Z';
        char maxLetter = 'A';
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                if(minLetter > ch) minLetter = ch;
                if(maxLetter < ch) maxLetter = ch;
            }
            else if(Character.isDigit(ch)){
                if(minNum > Character.getNumericValue(ch)) minNum = Character.getNumericValue(ch);
                if(maxNum < Character.getNumericValue(ch)) maxNum = Character.getNumericValue(ch);
            }
        }
        List<String> ans = new ArrayList<>();

        for(char ch = minLetter ; ch <= maxLetter ; ch++){
            for(int i = minNum ; i <= maxNum ; i++){
                String x = ch + String.valueOf(i);
                ans.add(x);
            }
        }
        return ans;
    }

}