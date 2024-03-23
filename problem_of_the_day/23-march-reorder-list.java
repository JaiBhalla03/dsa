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
    public ListNode reverse(ListNode head){
        ListNode dummy = null;
        while(head != null){
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode first = head;
        ListNode second = reverse(slow);
        while(first != null || second != null){
            if(first != null){
                temp.next = first;
                first = first.next;
                temp = temp.next;
            }
            if(second != null){
                temp.next = second;
                second = second.next;
                temp = temp.next;
            }
        }
        head = ans.next;
    }
}