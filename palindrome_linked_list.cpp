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
        ListNode* dummy = NULL;
        while(head != NULL){
            ListNode* next = head->next;
            head->next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast->next != NULL && fast->next->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* secondHalf = reverse(slow->next);
        slow->next = NULL;
        while(head != NULL && secondHalf != NULL){
            if(head->val != secondHalf->val) return false;
            head = head->next;
            secondHalf = secondHalf->next;
        }
        return true;
    }
};