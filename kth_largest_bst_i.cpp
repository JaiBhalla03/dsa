class Solution
{
public:
    void helper(Node* root, int &ans, int &count, int K){
        if(root == nullptr){
            return;
        }
        helper(root->right, ans, count, K);
        count++;
        if(K == count) {
            ans = root->data;
            return;
        }
        helper(root->left, ans, count, K);
    }
    int kthLargest(Node *root, int K)
    {
        int ans = 0;
        int count = 0;
        helper(root, ans, count, K);
        return ans;
    }
};