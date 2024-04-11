class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node middle(Node head){
        Node curr = head;
        if(curr == null || curr.next == null){
            return curr;
        }
        Node slow = curr;
        Node fast = curr.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static Node merge(Node a, Node b){
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
    static Node mergeSort(Node head)
    {

        if(head == null || head.next == null) return head;
        Node mid = middle(head);
        Node nextToMiddle = mid.next;
        mid.next = null;
        Node first = mergeSort(head);
        Node second = mergeSort(nextToMiddle);
        return merge(first, second);
    }
}


