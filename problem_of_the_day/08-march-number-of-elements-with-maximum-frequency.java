class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for(int i = 0 ; i < 101 ; i++){
            freq[i] = 0;
        }
        for(int x : nums){
            freq[x]++;
        }
        int maxFreq = 0;
        for(int i = 0 ; i < 101 ; i++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
            }
        }
        int count = 0;
        for(int x : nums){
            if(freq[x] == maxFreq) count++;
        }
        return count;
    }
}