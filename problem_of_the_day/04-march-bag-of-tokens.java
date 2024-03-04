class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        List<Integer> token = new ArrayList<>();
        for(int i = 0 ; i < tokens.length ; i++){
            token.add(tokens[i]);
        }
        Collections.sort(token);
        while(l <= r){
            if(power >= token.get(l)){
                power -= token.get(l);
                l++;
                score++;
                maxScore = Math.max(maxScore, score);
            }
            else if(score > 0){
                power += token.get(r);
                score--;
                r--;
            }
            else {
                break;
            }
        }
        return maxScore;
    }
}