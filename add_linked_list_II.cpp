/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverse(ListNode* head){
        ListNode* prev = nullptr;
        while(head != nullptr){
            ListNode* next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(-1);
        ListNode* temp = dummy;
        int carry = 0;
        l1 = reverse(l1);
        l2 = reverse(l2);
        while(l1 || l2 || carry){
            int sum = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
            carry = sum/10;
            temp->next = new ListNode(sum%10);
            temp = temp->next;
            if(l1) l1 = l1->next;
            if(l2) l2 = l2->next;
        }
        dummy = dummy->next;
        return reverse(dummy);
    }
};