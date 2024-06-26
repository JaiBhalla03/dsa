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
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* helper(vector<int> l, int start, int end){
        if(start > end){
            return nullptr;
        }
        int mid = (start + end)/2;
        TreeNode* root = new TreeNode(l[mid]);
        root->left = helper(l, start , mid-1);
        root->right = helper(l, mid+1 , end);
        return root;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        if(head == nullptr){
            return nullptr;
        }
        vector<int> l;
        ListNode* temp = head;
        while(temp){
            l.push_back(temp->val);
            temp = temp->next;
        }
        TreeNode* root = helper(l, 0, l.size()-1);
        return root;
    }
};