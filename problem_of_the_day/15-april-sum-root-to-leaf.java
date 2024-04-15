class Solution {
    public int helper(TreeNode root, int curr){
        if(root == null) return 0;
        curr = curr*10 + root.val;
        if(root.left == null && root.right == null){
            return curr;
        }
        return helper(root.left, curr) + helper(root.right, curr);
    }
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}