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
    public void helper(TreeNode root, ArrayList<Integer> inorder){
        if(root == null) return;
        helper(root.left, inorder);
        inorder.add(root.val);
        helper(root.right, inorder);
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        if(root == null) return true;
        helper(root, inorder);
        for(int i = 1 ; i <= inorder.size() - 1 ; i++){
            if(inorder.get(i-1) >= inorder.get(i)) return false;
        }
        return true;
    }
}