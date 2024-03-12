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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return head;
        ListNode curr = head;
        int sum = 0;
        while(curr != null){
            sum = sum + curr.val;
            if(sum == 0){
                head = curr.next;
                return removeZeroSumSublists(head);
            }
            curr = curr.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}