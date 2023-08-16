//first approach the takes a extra vector to store all the number

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
    int pairSum(ListNode* head) {
        ListNode* temp = head;
        vector<int> nums;
        while(temp != nullptr){
            nums.push_back(temp->val);
            temp=temp->next;
        }
        int maxSum = INT_MIN;
        int l = 0, r=nums.size()-1;
        while(l<=r){
            int sum = nums[l] + nums[r];
            l++;
            r--;
            maxSum = max(maxSum, sum);
        }
        return maxSum;
    }
};

//approach - 2
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
    ListNode* reverse(ListNode* head){
        ListNode* dummy = nullptr;
        while(head != nullptr){
            ListNode* nextNode = head->next;
            head->next = dummy;
            dummy = head;
            head = nextNode;
        }
        return dummy;
    }
    int pairSum(ListNode* head) {
        int maxSum =INT_MIN;
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast != NULL && fast->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        if(fast == NULL){
            slow = reverse(slow);
        }
        else{
            maxSum = max(slow->val, maxSum);
            slow = slow->next;
            slow = reverse(slow);
        }
        while(slow != NULL){
            maxSum = max(slow->val + head->val, maxSum);
            slow = slow->next;
            head = head->next;
        }
        return maxSum;
    }
};

//in this approach we are the using the approach to find the palindrome just keeping the count of the twin sum and the maximum twin