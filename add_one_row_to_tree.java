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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty() && depth != 1){
            int levelSize = q.size();
            depth--;
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode node = q.poll();
                if(depth == 1){
                    // if(node.left != null){
                    TreeNode tempLeft = node.left;
                    node.left = new TreeNode(val);
                    node.left.left = tempLeft;
                    // }
                    // if(node.right != null){
                    TreeNode tempRight = node.right;
                    node.right = new TreeNode(val);
                    node.right.right = tempRight;
                    // }
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return root;
    }
}