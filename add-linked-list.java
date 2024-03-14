class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverse(Node head){
        Node dummy = null;
        while(head != null){
            Node next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
    static Node addTwoLists(Node first, Node second){
        Node ans = new Node(-1);
        Node curr = ans;
        Node l1 = reverse(first);
        Node l2 = reverse(second);
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null) sum += l1.data;
            if(l2 != null) sum += l2.data;
            Node newNode = new Node(sum%10);
            carry = sum/10;
            curr.next = newNode;
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0){
            Node newNode = new Node(carry);
            curr.next = newNode;
        }
        return reverse(ans.next);
    }
}