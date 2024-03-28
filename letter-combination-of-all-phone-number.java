class Solution {
    public String[] keypad= {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void calculate(int index, String digits, StringBuilder helper, List<String> combination){
        if(index == digits.length()){
            combination.add(helper.toString());
            return;
        }
        int number = digits.charAt(index) - '0';
        for(int i = 0 ; i < keypad[number].length() ; i++){
            helper.append(keypad[number].charAt(i));
            calculate(index + 1, digits, helper, combination);
            helper.deleteCharAt(helper.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> combination = new ArrayList<String>();
        if(digits.length() == 0) return combination;
        StringBuilder helper = new StringBuilder();
        calculate(0, digits, helper, combination);
        return combination;
    }
}