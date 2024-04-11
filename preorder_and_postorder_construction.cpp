LeetCode Logo
Problem List
0

avatar
        Premium
Debugging...
        Debugging...







Run
        Description
Editorial
        Editorial
Solutions
        Solutions
Submissions
        Submissions

Testcase
        Testcase
Code
        Result
Result

889. Construct Binary Tree from Preorder and Postorder Traversal
        Solved
Medium
        Topics
Companies
        Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.



Example 1:


Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
Example 2:

Input: preorder = [1], postorder = [1]
Output: [1]


Constraints:

1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
        All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
        All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.
Accepted
94.6K
Submissions
132.8K
Acceptance Rate
71.2%
Seen this question in a real interview before?
1/4
Yes
        No
Discussion (7)
Copyright ©️ 2023 LeetCode All rights reserved

2.6K

104



C++
Auto



1415161718192021222324252627282930313233343536
}
TreeNode* solve(vector<int> preorder, vector<int> postorder, int start, int end){
    if(start > end || preindex >= preorder.size()){ return nullptr; }
    TreeNode* root = new TreeNode(preorder[preindex++]);
    if(start == end || preindex >= preorder.size()){
        return root;
    }
    int pos = search(postorder, start, end, preorder[preindex]);
    root->left = solve(preorder, postorder, start, pos);

    Saved to local
