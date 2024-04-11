class Tree
{
    public ArrayList<Integer> diagonal(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            while(node != null){
                ans.add(node.data);
                if(node.left != null) q.add(node.left);
                node = node.right;
            }
        }
        return ans;
    }
}
