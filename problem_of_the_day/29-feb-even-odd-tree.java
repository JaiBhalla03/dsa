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
    public boolean oddIncreasing(List<Integer> arr){
        if(arr.size() == 1){
            return arr.get(0) % 2 == 1;
        }
        else if(arr.size() > 0 && arr.get(0) % 2 == 0) return false;
        for(int i = 1 ; i < arr.size() ; i++){
            if((arr.get(i) <= arr.get(i-1)) || arr.get(i) % 2 == 0) return false;
        }
        return true;
    }
    public boolean evenDecreasing(List<Integer> arr){
        if(arr.size() == 1){
            return arr.get(0) % 2 == 0;
        }
        else if(arr.size() > 0 && arr.get(0) % 2 == 1) return false;
        for(int i = 1 ; i < arr.size() ; i++){
            if((arr.get(i) >= arr.get(i-1)) || arr.get(i) % 2 == 1) return false;
        }
        return true;
    }
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(temp);
        }

        boolean flag = true;
        for(int i = 0 ; i < ans.size() ; i++){
            List<Integer> temp = ans.get(i);
            if(flag){
                if(!oddIncreasing(temp)) return false;
            }
            else{
                if(!evenDecreasing(temp)) return false;
            }
            flag = !flag;
        }
        return true;
    }
}