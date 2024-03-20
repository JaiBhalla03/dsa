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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode t = ans;
        int count = 0;
        ListNode temp = list1;
        while(count != a){
            t.next = new ListNode(temp.val);
            t = t.next;
            temp = temp.next;
            count++;
        }
        t.next = list2;
        ListNode end = ans;
        while(end.next != null) end = end.next;
        count = 0;
        temp = list1;
        while(count != b+1){
            temp = temp.next;
            count++;
        }
        end.next = temp;
        return ans.next;
    }
}