class Solution
{
public:
    void helper(Node* root, int K, int &count, int &ans){
        if(root == nullptr) return;
        helper(root->right, K, count, ans);
        count++;
        if(K == count){
            ans = root->data;
            return;
        }
        helper(root->left, K, count, ans);
    }
    int kthLargest(Node *root, int K)
    {
        int count = 0;
        int ans;
        helper(root, K, count, ans);
        return ans;
    }
};