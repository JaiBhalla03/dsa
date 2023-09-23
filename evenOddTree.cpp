/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isStrictlyIncreasing(vector<int> arr){
        if(arr.size() == 1) return true;
        for(int i = 1 ; i < arr.size() ; i++){
            if(arr[i] <= arr[i-1]) return false;
        }
        return true;
    }
    bool isStrictlyDecreasing(vector<int> arr){
        if(arr.size() == 1) return true;
        for(int i = 1 ; i < arr.size() ; i++){
            if(arr[i] >= arr[i-1]) return false;
        }
        return true;
    }
    bool isOdd(vector<int> arr){
        for(auto x : arr){
            if(x%2 == 0) return false;
        }
        return true;
    }
    bool isEven(vector<int> arr){
        for(auto x : arr){
            if(x%2 == 1) return false;
        }
        return true;
    }
    bool isEvenOddTree(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        vector<int> temp;
        bool flag = true;
        while(!q.empty()){
            int levelSize = q.size();
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode* node = q.front();
                q.pop();
                temp.push_back(node->val);
                if(node->left){
                    q.push(node->left);
                }
                if(node->right){
                    q.push(node->right);
                }
            }
            if(flag){
                if(!isStrictlyIncreasing(temp) || !isOdd(temp)) return false;
            }
            else{
                if(!isStrictlyDecreasing(temp) || !isEven(temp)) return false;
            }
            flag = !flag;
            temp.clear();
        }
        return true;
    }
};