class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0 ; i < k ; i++){
            st.push(q.peek());
            q.remove();
        }
        Queue<Integer> ans = new LinkedList<>();
        for(int i = 0 ; i < k ; i ++){
            ans.add(st.pop());
        }
        while(q.size() != 0){
            ans.add(q.peek());
            q.remove();
        }
        return ans;
    }
}