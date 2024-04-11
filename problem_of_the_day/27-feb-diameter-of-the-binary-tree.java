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
class Height{
    int h;
}

class Solution {
    int util(TreeNode root, Height height){
        Height lh = new Height();
        Height rh = new Height();
        if(root == null){
            height.h = 0;
            return 0;
        }
        int ld = util(root.left, lh);
        int rd = util(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h , Math.max(ld, rd));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Height h = new Height();
        return util(root, h);
    }
}