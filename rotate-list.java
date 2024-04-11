class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        Node curr = head;
        Node prev = head;
        while(k != 0){
            prev = curr;
            curr = curr.next;
            k--;
        }
        prev.next = null;
        Node ans = new Node(-1);
        Node temp = ans;
        while(curr != null){
            temp.next = new Node(curr.data);
            curr = curr.next;
            temp = temp.next;
        }
        temp.next = head;
        return ans.next;
    }
}