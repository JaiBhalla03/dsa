class Solution {
public:
    bool flipEquiv(TreeNode* root1, TreeNode* root2) {
        if (!root1 && !root2) {
            return true;
        }
        if (!root1 || !root2 || root1->val != root2->val) {
            return false;
        }

        // Check without flipping
        bool withoutFlip = (flipEquiv(root1->left, root2->left) && flipEquiv(root1->right, root2->right));

        // Check with flipping
        bool withFlip = (flipEquiv(root1->left, root2->right) && flipEquiv(root1->right, root2->left));

        return withoutFlip || withFlip;
    }
};
