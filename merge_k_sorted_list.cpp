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
    bool isEmpty(vector<ListNode*> lists){
        for(auto x : lists){
            if(x){
                return false;
            }
        }
        return true;
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size() == 0 || (lists.size() == 1 && lists[0] == nullptr)){
            return nullptr;
        }
        ListNode* dummy = new ListNode(-1);
        ListNode* temp = dummy;
        while(!isEmpty(lists)){
            int min = INT_MAX;
            int index = 0;
            for(int i = 0 ; i < lists.size() ; i++){
                if(lists[i] && lists[i]->val < min){
                    min = lists[i]->val;
                    index = i;
                }
            }
            temp->next = new ListNode(min);
            lists[index] = lists[index]->next;
            temp = temp->next;
        }
        return dummy->next;
    }
};