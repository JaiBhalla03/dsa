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
    ListNode* removeNodes(ListNode* head) {
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode* prev = dummy;
        ListNode* curr = head;
        ListNode* temp = head;
        bool flag = false;
        while(curr != nullptr){
            while(temp != nullptr){
                if(temp->val > curr->val){
                    flag = true;
                }
                temp = temp->next;
            }
            if(flag){
                prev->next = curr->next;
                delete curr;
                curr = prev->next;
                temp = curr;
                flag = false;
            }
            else{
                prev = curr;
                curr = curr->next;
                temp = curr;
            }
        }
        return dummy->next;
    }
};

//efficient method