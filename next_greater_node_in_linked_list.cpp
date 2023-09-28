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
    int find(ListNode* node){
        ListNode* temp = node;
        int value = temp->val;
        temp = temp->next;
        while(temp){
            if(value < temp->val){
                return temp->val;
            }
            temp = temp->next;
        }
        return 0;
    }
    vector<int> nextLargerNodes(ListNode* head) {
        vector<int> ans;
        ListNode* temp = head;
        while(temp){
            ans.push_back(find(temp));
            temp = temp->next;
        }
        return ans;
    }
};