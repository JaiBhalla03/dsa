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
    ListNode* mergeNodes(ListNode* head) {
        ListNode* result = new ListNode(0);
        ListNode* dummy = result;
        ListNode* curr = head;
        while(curr->next != nullptr){
            int sum = 0;
            while(curr->next->val != 0){
                sum+=curr->next->val;
                curr = curr->next;
            }
            dummy->next = new ListNode(sum);
            dummy = dummy->next;
            curr = curr->next;
        }
        return result->next;
    }
};