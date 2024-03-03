/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int length(ListNode head){
        if(head == null) return 0;
        return 1 + length(head.next);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //get the length of the linkedlist
        int len = length(head);
        int n1 = len - n + 1;
        ListNode temp = head;
        ListNode prev = null;
        for(int i = 1 ; i < n1 ; i++){
            prev = temp;
            temp = temp.next;
        }
        if(prev == null){
            return head.next;
        }
        else{
            prev.next = prev.next.next;
        }
        return head;
    }
}