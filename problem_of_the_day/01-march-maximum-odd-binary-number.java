class Solution {
    public String maximumOddBinaryNumber(String s) {
        ArrayList<Character> ans = new ArrayList<>();
        int len = s.length();
        int numZero = 0;
        for(int i = 0 ; i < len ; i++){
            ans.add('0');
            if(s.charAt(i) == '1') numZero++;
        }
        if(numZero > 0){
            ans.set(ans.size() - 1, '1');
            numZero--;
        }
        int i = 0;
        while(numZero != 0){
            ans.set(i, '1');
            i++;
            numZero--;
        }
        String result = "";
        for(char ch : ans){
            result += ch;
        }
        return result;
    }
}