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
    int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return head;
        ListNode* curr = head;
        while(curr->next != nullptr){
            ListNode* nextNode = curr->next;
            ListNode* middle = new ListNode(gcd(curr->val ,nextNode->val));
            middle->next = curr->next;
            curr->next = middle;
            curr = curr->next->next;
        }
        return head;
    }
};