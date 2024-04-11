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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(root.left == null){
            TreeNode temp = root.right;
            return temp;
        }
        else if(root.right == null){
            TreeNode temp = root.left;
            return temp;
        }
        else{
            TreeNode parent = root;
            TreeNode succ = root.right;
            while(succ.left != null){
                parent = succ;
                succ = succ.left;
            }
            if(parent != root){
                parent.left = succ.right;
            }
            else{
                parent.right = succ.right;
            }
            root.val = succ.val;
            return root;
        }
    }
}