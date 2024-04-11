class Solution{
public:
    void inOrder(Node* root, vector<int>& inorder){
        if(root == nullptr){
            return;
        }
        inOrder(root->left, inorder);
        inorder.push_back(root->data);
        inOrder(root->right, inorder);
    }
    Node* constructBST(vector<int> inorder, int start, int end){
        if(start > end){
            return nullptr;
        }
        int mid = (start + end)/2;
        Node* node = new Node(inorder[mid]);
        node->left = constructBST(inorder, start, mid-1);
        node->right = constructBST(inorder, mid+1, end);
        return node;
    }
    Node *binaryTreeToBST (Node *root)
    {
        vector<int> inorder;
        inOrder(root, inorder);
        sort(inorder.begin() , inorder.end());
        return constructBST(inorder, 0 , inorder.size()-1);
    }
};