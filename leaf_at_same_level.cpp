class Solution{
public:
    /*You are required to complete this method*/
    bool helper(Node* root, int level, int &leafLevel){
        if(root == nullptr) return true;
        if(root->left == nullptr && root->right == nullptr){
            if(leafLevel == -1){
                leafLevel = level;
            }
            else if(leafLevel != level){
                return false;
            }
        }
        return helper(root->left, level + 1 , leafLevel) && helper(root->right, level + 1, leafLevel);
    }
    bool check(Node *root)
    {
        int level = 0;
        int leafLevel = -1;
        return helper(root, level, leafLevel);
    }
};