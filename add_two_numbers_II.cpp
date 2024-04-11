//brute force approach
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
    void insertAtHead(ListNode*& result, int val){
        ListNode* newNode = new ListNode(val);
        newNode->next = result;
        result = newNode;
    }
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int n1 = 0;
        int n2 = 0;
        while(l1 != nullptr){
            n1 = n1*10 + l1->val;
            l1 = l1->next;
        }
        while(l2 != nullptr){
            n2 = n2*10 + l2->val;
            l2 = l2->next;
        }
        int ans = n1 + n2;
        ListNode* result = nullptr;
        if(ans == 0){
            return new ListNode(0);
        }
        while(ans != 0){
            int d = ans%10;
            ans = ans/10;
            insertAtHead(result, d);
        }
        return result;
    }
};

//this approach won't work when we have a really long linked list for that have the create the linked list without changing it
// to the integer

/*
 *
 * */