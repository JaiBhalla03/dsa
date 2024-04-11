class Solution {
    public int leastInterval(char[] tasks, int n) {
        //get the frequency of each tasks
        int[] freq = new int[26];
        for(int i = 0 ; i < tasks.length ; i++){
            freq[tasks[i] - 'A']++;
        }
        Arrays.sort(freq);

        int chunk = freq[25] - 1;
        int idleSlots = chunk*n;
        for(int i = 24 ; i>=0 && freq[i] > 0 ;i--){
            idleSlots -= Math.min(chunk, freq[i]);
        }
        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}