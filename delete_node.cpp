/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return;
        ListNode* nextNode = head->next;
        head->val = nextNode->val;
        head->next = nextNode->next;
        delete nextNode;
    }
};