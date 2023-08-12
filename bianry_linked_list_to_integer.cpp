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
    int getDecimalValue(ListNode* head) {
        ListNode* temp = head;
        int count=  0;
        while(temp->next != NULL){
            temp = temp->next;
            count++;
        }
        //count--;
        int ans=0;
        temp = head;
        while(temp != NULL){
            ans+=temp->val*pow(2,count);
            count--;
            temp = temp->next;
        }
        return ans;
    }
};