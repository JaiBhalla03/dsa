class twoStacks
{
    int top1;
    int top2;
    int size;
    int arr[];
    twoStacks()
    {
        int n = 500;
        size = n;
        top1 = n/2;
        top2 = n/2 + 1;
        arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = -1;
        }
    }
    //Function to push an integer into the stack1.
    void push1(int x)
    {
        if(top1 > 0){
            top1--;
            arr[top1] = x;
        }
        else{
            return;
        }
    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
        if(top2 < size - 1){
            top2 ++;
            arr[top2] = x;
        }
        else{
            return;
        }
    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
        if(top1 <= size/2){
            int x = arr[top1];
            top1 ++;
            return x;
        }
        else{
            return -1;
        }
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        if(top2 >= size/2 + 1){
            int x = arr[top2];
            top2--;
            return x;
        }
        else{
            return -1;
        }
    }
}
