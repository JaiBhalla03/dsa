class Solution{
public:
    void helper(Node* root, vector<int> &inOrder){
        if(root == nullptr){
            return;
        }
        helper(root->left, inOrder);
        inOrder.push_back(root->data);
        helper(root->right, inOrder);
    }
    Node* constructBST(Node* root, vector<int> inOrder, int start, int end){
        if(start > end){
            return nullptr;
        }
        int mid = (start + end)/2;
        Node* node = new Node(inOrder[mid]);
        node->left = constructBST(root, inOrder, start, mid-1);
        node->right = constructBST(root, inOrder, mid+1, end);
        return node;
    }
    Node *binaryTreeToBST (Node *root)
    {
        vector<int> inOrder;
        helper(root, inOrder);
        sort(inOrder.begin(), inOrder.end());
        return constructBST(root, inOrder, 0, inOrder.size()-1);
    }
};