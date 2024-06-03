class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            adj.computeIfAbsent(src, key -> new PriorityQueue<>()).add(dest);
        }
        Stack<String> st = new Stack<>();
        st.push("JFK");
        while (!st.isEmpty()) {
            String src = st.peek();
            PriorityQueue<String> destinations = adj.get(src);

            if (destinations == null || destinations.isEmpty()) {
                ans.add(0, src);
                st.pop();
            } else {
                st.push(destinations.poll());
            }
        }

        return ans;
    }
}