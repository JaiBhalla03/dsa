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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return -1;
        q.add(root);
        while(q.size() > 0){
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < levelSize ; i ++){
                TreeNode node = q.remove();
                temp.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(temp);
        }
        return ans.get(ans.size() - 1).get(0);
    }
}