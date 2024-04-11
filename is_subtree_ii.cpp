class Solution
{
public:
    bool isIdentical(Node* root1, Node* root2){
        if(root1 == nullptr && root2 == nullptr) return true;
        if(root1 == nullptr || root2 == nullptr) return false;
        return root1->data == root2->data
               && isIdentical(root1->left, root2->left)
               && isIdentical(root1->right, root2->right);
    }
    bool isSubTree(Node* T, Node* S)
    {
        if(S == nullptr) return true;
        if(T == nullptr) return false;
        if(isIdentical(T, S)) return true;
        return isSubTree(T->left, S) || isSubTree(T->right, S);
    }
};