class Solution
{
    //Function to merge K sorted linked list.
    Node merge(Node a, Node b){
        Node result = null;
        if(a == null) return b;
        if(b == null) return a;
        if(a.data < b.data){
            result = a;
            result.next = merge(a.next, b);
        }
        else{
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }
    Node mergeKList(Node[]arr,int K)
    {
        int last = K - 1;
        while(last != 0){
            int i = 0;
            int j = last;
            while(i < j){
                arr[i] = merge(arr[i], arr[j]);
                i++;
                j--;
                if(i >= j){
                    last = j;
                }
            }
        }
        return arr[0];
    }
}