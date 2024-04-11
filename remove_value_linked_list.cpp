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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* prev = dummy;
        ListNode* current = head;
        while(current != NULL){
            if(current->val == val){
                prev->next = current->next;
                delete(current);
                current = prev->next;
            }
            else{
                prev = current;
                current = current->next;
            }
        }
        ListNode* newNode = dummy->next;
        delete dummy;
        return newNode;
    }
};