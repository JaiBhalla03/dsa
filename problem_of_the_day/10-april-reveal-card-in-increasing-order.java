class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        if(n <= 2){
            Arrays.sort(deck);
            return deck;
        }
        int[] ans = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.sort(deck);
        q.add(deck[n-1]);
        for(int i = n - 2 ; i >=0 ; i--){
            int last = q.removeLast();
            q.addFirst(last);
            q.addFirst(deck[i]);
        }
        for(int i = 0 ; i < n ; i++){
            ans[i] = q.removeFirst();
        }
        return ans;
    }
}