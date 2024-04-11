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
    ListNode* oddEvenList(ListNode* head) {
        if(
                head == nullptr ||
                head->next == nullptr ||
                head->next->next == nullptr
                ) {
            return head;
        }
        ListNode* temp = head;
        ListNode* nextNode = new ListNode(0);
        ListNode* even = new ListNode(0);
        even->next = nextNode;
        while(temp != nullptr && temp->next != nullptr){
            nextNode->next = temp->next;
            temp->next = temp->next->next;
            nextNode->next->next = (nextNode->next->next == nullptr) ? nullptr : nextNode->next->next->next;
            temp = temp->next;
            nextNode = nextNode->next;
        }
        temp = head;
        while(temp->next != nullptr){
            temp = temp->next;
        }
        temp->next = even->next->next;
        return head;
    }
};