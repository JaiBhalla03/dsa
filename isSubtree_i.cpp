class Solution
{
public:
    bool isIdentical(Node* root1, Node* root2){
        if(root1 == nullptr && root2 == nullptr) return true;
        if(root1 == nullptr || root2 == nullptr) return false;
        return root1->data == root2->data &&
               isIdentical(root1->left, root2->left) &&
               isIdentical(root1->right, root2->right);
    }
    void helper(Node* T, Node* S, bool &check){
        if(T == nullptr) return;
        if(isIdentical(T, S)) check = true;
        helper(T->left, S, check);
        helper(T->right, S, check);
    }
    bool isSubTree(Node* T, Node* S)
    {
        bool check = false;
        helper(T, S, check);
        return check;
    }
};