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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int length = 0;
        ListNode* temp = head;
        while(temp != nullptr){
            temp = temp->next;
            length++;
        }
        if(n == length) return head->next;
        ListNode* curr = head;
        ListNode* prev = nullptr;
        int count = length - n;
        while(count != 0){
            prev = curr;
            curr = curr->next;
            count --;
        }
        prev->next = curr->next;
        delete curr;
        return head;
    }
};