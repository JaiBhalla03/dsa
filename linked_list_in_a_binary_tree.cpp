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
    bool checkSubPaths(ListNode* head, TreeNode* root){
        if(head == nullptr) return true;
        if(root == nullptr) return false;
        if(head->val == root->val){
            return checkSubPaths(head->next, root->left) || checkSubPaths(head->next, root->right);
        }
        return false;
    }
    bool isSubPath(ListNode* head, TreeNode* root) {
        if(head == nullptr) return true;
        if(root == nullptr) return false;

        return checkSubPaths(head, root) || isSubPath(head, root->left) || isSubPath(head, root->right);
    }
};