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
    public void dfs(TreeNode root, StringBuilder path, StringBuilder smallest){
        if(root == null){
            return;
        }
        path.append((char)('a' + root.val));
        if(root.left == null && root.right == null){
            String currentString = path.reverse().toString();
            if(smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0){
                smallest.setLength(0);
                smallest.append(currentString);
            }
            path.reverse();
        }
        dfs(root.left, path, smallest);
        dfs(root.right, path, smallest);
        path.setLength(path.length() - 1);
    }
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        dfs(root, new StringBuilder(), smallest);
        return smallest.toString();
    }
}