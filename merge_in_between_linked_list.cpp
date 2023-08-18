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
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        int diff = b-a;
        ListNode* temp = list1;
        ListNode* temp1 = list1->next;
        a--;
        while(a!=0){
            temp = temp->next;
            temp1 = temp1->next;
            a--;
        }
        temp->next = list2;
        while(diff != 0){
            diff--;
            temp1 = temp1->next;
        }
        ListNode* end = temp1->next;
        while(temp->next != nullptr){
            temp = temp->next;
        }
        temp->next = end;
        return list1;
    }
};