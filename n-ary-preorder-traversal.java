/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void helper(Node root, List<Integer> ans){
        if(root.children.size() > 0) ans.add(root.val);
        else if(root.children.size() == 0){
            ans.add(root.val);
            return;
        }
        for(int i = 0 ; i < root.children.size() ; i++){
            helper(root.children.get(i), ans);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        helper(root, ans);
        return ans;
    }
}