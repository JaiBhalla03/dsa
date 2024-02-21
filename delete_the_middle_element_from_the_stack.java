class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        int x = sizeOfStack/2 + 1;
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 1 ; i <= sizeOfStack ; i++){
            if(i == x){
                s.pop();
            }
            else{
                int top = s.peek();
                s.pop();
                st.push(top);
            }
        }
        for(int i = 1 ; i < sizeOfStack ; i++){
            s.push(st.pop());
        }
    }
}
