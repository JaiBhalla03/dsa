/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = -1;
    public int helper(TreeNode root, int k){
        if(root == null) return 0;
        int left = 1 + helper(root.left, k);
        if(left == k) ans = root.val;
        return left + helper(root.right, k - left);
    }
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }
}