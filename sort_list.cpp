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
    void insert(ListNode* &head, int data){
        if(head == nullptr){
            head = new ListNode(data);
            return;
        }
        ListNode* end = head;
        while(end->next != nullptr){
            end = end->next;
        }
        end->next = new ListNode(data);
        return;
    }
    ListNode* sortList(ListNode* head) {
        vector<int> arr;
        ListNode* temp = head;
        while(temp != nullptr){
            arr.push_back(temp->val);
            temp = temp->next;
        }
        sort(arr.begin(), arr.end());
        ListNode* head1 = nullptr;
        for(int i = 0  ;i <arr.size() ; i++){
            insert(head1, arr[i]);
        }
        return head1;
    }
};

//efficient approach
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
    ListNode* merge(ListNode* f, ListNode* s){
        ListNode* h1 = f;
        ListNode* h2 = s;
        ListNode* head;
        if(h1->val <= h2->val){
            head = h1;
            h1 = h1->next;
        }
        else{
            head = h2;
            h2 = h2->next;
        }
        ListNode* h = head;
        while(h1 != nullptr && h2 != nullptr){
            if(h1->val <= h2->val){
                h->next = h1;
                h = h1;
                h1 = h1->next;
            }
            else{
                h->next = h2;
                h = h2;
                h2 = h2->next;
            }
        }
        if(h1 != nullptr){
            h->next = h1;
        }
        if(h2 != nullptr){
            h->next = h2;
        }
        return head;
    }
    ListNode* sortList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return head;
        ListNode* slow = head;
        ListNode* fast = head->next;
        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* second = slow->next;
        slow->next = nullptr;
        ListNode* firstPart = sortList(head);
        ListNode* secondPart = sortList(second);
        return merge(firstPart, secondPart);
    }
};