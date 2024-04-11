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
    ListNode* swapNodes(ListNode* head, int k) {
        int count = 0;
        ListNode* temp = head;
        ListNode* p1 = head;
        ListNode* p2 = head;
        while(temp != nullptr){
            temp = temp->next;
            count++;
        }
        int first = k-1;
        int second = count-k;
        while(first != 0){
            p1 = p1->next;
            first--;
        }
        while(second != 0){
            p2 = p2->next;
            second--;
        }
        int t = p1->val;
        p1->val = p2->val;
        p2->val = t;
        return head;
    }
};