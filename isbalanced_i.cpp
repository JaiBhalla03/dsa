class Solution{
public:
    int height(Node* root){
        if(root == nullptr){
            return 0;
        }
        return 1 + max(height(root->left), height(root->right));
    }
    void helper(Node* root, bool &check){
        if(root == nullptr){
            return;
        }
        if(abs(height(root->left) - height(root->right)) > 1) check = false;
        helper(root->left, check);
        helper(root->right, check);
    }
    bool isBalanced(Node *root)
    {
        bool check = true;
        helper(root, check);
        return check;
    }
};