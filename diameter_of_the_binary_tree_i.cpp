class Solution {
public:
    // Function to return the diameter of a Binary Tree.
    int util(Node* root, int *height){
        int lh = 0; int rh = 0; int ldiameter = 0; int rdiameter = 0;
        if(root == nullptr){
            *height = 0;
            return 0;
        }
        ldiameter = util(root->left, &lh);
        rdiameter = util(root->right, &rh);
        *height = max(lh, rh) + 1;
        return max(lh + rh + 1 , max(ldiameter, rdiameter));
    }
    int diameter(Node* root) {
        int height = 0;
        int ans = util(root, &height);
        return ans;
    }
};