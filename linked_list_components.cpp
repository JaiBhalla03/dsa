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
    int numComponents(ListNode* head, vector<int>& nums) {
        if(head == nullptr) return 0;
        unordered_set<int> s{nums.begin(), nums.end()};
        int count = 0;
        while(head != nullptr){
            if(s.find(head->val) != s.end()){
                count++;
                while(head->next && s.find(head->next->val) != s.end()){
                    head = head->next;
                }
            }
            head = head->next;
        }
        return count;
    }
};