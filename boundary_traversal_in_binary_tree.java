class Solution
{
    boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    void addLeft(Node node, ArrayList<Integer> ans){
        node = node.left;
        while(node != null){
            if(!isLeaf(node)){
                ans.add(node.data);
            }
            if(node.left != null) node = node.left;
            else node = node.right;
        }
    }
    void addLeaves(Node node, ArrayList<Integer> ans){
        if(node != null && isLeaf(node)){
            ans.add(node.data);
        }
        if(node == null) return;
        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }
    void addRight(Node node, ArrayList<Integer> ans){
        node = node.right;
        Stack<Integer> st = new Stack<>();
        while(node != null){
            if(!isLeaf(node)){
                st.push(node.data);
            }
            if(node.right != null) node = node.right;
            else node = node.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
    }
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;
        //adding root
        ans.add(node.data);
        if(isLeaf(node)) return ans;
        //adding the left side
        addLeft(node, ans);
        //adding the leafs
        addLeaves(node, ans);
        //adding the right side
        addRight(node, ans);
        return ans;
    }
}
