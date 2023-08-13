class Solution {
public:
    int search(vector<int>& inorder, int start, int end, int x){
        for(int i = start; i <= end; i++){
            if(inorder[i] == x) return i;
        }
        return -1;
    }

    TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int start, int end, int& index){
        if(start > end){
            return nullptr;
        }

        int n = preorder[index];
        index++;
        TreeNode* node = new TreeNode(n);
        if(start == end) return node;

        int pos = search(inorder, start, end, n);
        node->left = helper(preorder, inorder, start, pos-1, index);
        node->right = helper(preorder, inorder, pos+1, end, index);
        return node;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int index = 0;  // Initialize index
        return helper(preorder, inorder, 0, inorder.size() - 1, index);
    }
};
