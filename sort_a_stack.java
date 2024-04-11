class GfG{
    public void stackInsert(Stack<Integer> s, int x){
        if(s.isEmpty() || x > s.peek()){
            s.push(x);
            return;
        }
        int temp = s.pop();
        stackInsert(s, x);
        s.push(temp);
    }
    public void sortStack(Stack<Integer> s){
        if(!s.isEmpty()){
            int x = s.pop();
            sortStack(s);
            stackInsert(s, x);
        }
    }
    public Stack<Integer> sort(Stack<Integer> s)
    {
        sortStack(s);
        return s;
    }
}