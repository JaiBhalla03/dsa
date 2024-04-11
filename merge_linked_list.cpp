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
    ListNode* merge(ListNode* a, ListNode* b) {
        if(a == nullptr) return b;
        if(b == nullptr) return a;
        ListNode* result  = nullptr;
        if(a->val < b->val){
            result = a;
            result->next = merge(a->next , b);
        }
        else{
            result = b;
            result->next = merge(a, b->next);
        }
        return result;
    }
};